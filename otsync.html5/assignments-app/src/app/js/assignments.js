/**
 * # Assignments
 * An assignment viewer component for
 * OpenText Application Gateway.
 *
 * **Version** 1.0.0
 */

/* jshint forin:true, noarg:true, noempty:true, eqeqeq:true, bitwise:true,
 strict:true, undef:true, unused:true, curly:true, browser:true,
 jquery: true */
/* global App */

;(function () {
    // Keep JavaScript definitions strict
    "use strict";

    // Create the application
    var Assignments = new App(true);
    var deviceStrategy = Assignments.getDeviceStrategy();
    var _gatewayURL = null;

    /**
     * ## Initialization
     * Set up initial events and load data.
     */

    /**
     * ### Assignments.init
     *
     * Application initialization.
     */
    Assignments.init = function () {
        // Only trigger the initialization once
        if (this.initialized) {
            return;
        }
        this.initialized = true;

        // Bind events for the application
        bindEvents();

        deviceStrategy.getGatewayURL()
            .done(function (gatewayURL) {
                _gatewayURL = gatewayURL;
                // Get assignment list data
                getAssignments();
            })
            .fail(function (error) {
                alert(error);
            });
    };

    /**
     * ### bindEvents
     *
     * Bind any events for the page.
     */
    function bindEvents() {
        $(document.body)
            .on("click", "#assignments > li", function (event) {
                // dont toggle metadata -- recommendation from OTE Functionality Issues Doc
                //$(this).find(".metadata").toggle();
            })
            .on("click", "#assignments > li .open-assignment", function (event) {
                // Don't trigger default events
                event.preventDefault();
                event.stopPropagation();

                // Open the assignment
                openAssignment($(this).parents("li").data("assignment"));
            })
            .on("click", "#btnRefresh", function(event) {
              getAssignments();
            });
    }

    /**
     * ## Data Loading
     * Load data for the application.
     */

    /**
     * ### getAssignments
     *
     * Get the assignments list from the server.
     */
    function getAssignments() {
        clearData();
        $.when(Assignments.runRequestWithAuth({url: _gatewayURL + "/assignments/v5/assignments"}))
            .done(function (data) {
                showData(data.assignments);
            }).fail(function (error) {
            onError(apputil.T("label.Error") + error);
        });
    }

    /**
     * #### onError
     *
     * Clear list data and show the error.
     *
     * @param error    The error message string.
     */
    function onError(error) {
        clearData();
        $("#page-title").text(error);
    }

    /**
     * ## Display Data
     * Bind the data to fields within the application and
     * show it to the user.
     */

    /**
     * ### showData
     *
     * Bind the data to the view.
     *
     * @param data    Object containing the assignment list data.
     */
    function showData(data) {
        var idx, dataLen = data.length, lst = [],
            assignment, $row, priority, overdue;

        if (dataLen === 0) {
            $('#assignments').append($('<li style="text-align:center;">There are no items to display.</li>'));
        } else {
            for (idx = 0; idx < dataLen; idx += 1) {
                assignment = data[idx];

                // Get the priority
                priority = formatPriority(assignment.priority);
                overdue = (assignment.due && new Date(assignment.due) < new Date());

                // Create the element
                // note: cursor: pointer is a workaround for an iOS bug which prevents clicks on non-anchors from firing
                lst.push("<li style='cursor: pointer' data-type='" + assignment.type +
                    "' data-id='" + assignment.id +
                    "' data-subwork='" + assignment.subwork +
                    "' data-step='" + assignment.step +
                    "'>");
                lst.push('<div class="row-fluid">');

                // Add the basic information
                lst.push('<div class="span10">');

                // Assignment Name
                lst.push("<h4>" +
                    assignment.name.replace(/</g, "&lt;").replace(/>/g, "&gt;") +
                    "</h4>");

                // Location
                lst.push("<div><span class='grid-heading'>" + apputil.T("label.Location") + ":</span> " +
                    assignment.location + "</div>");

                // Due Date
                lst.push("<div><span class='grid-heading'>" + apputil.T("label.Due") + ":</span> " +
                    "<span" + (overdue ? " class='overdue'" : "") + ">" +
                    (assignment.due ? Assignments.format.date(assignment.due) : apputil.T("label.None")) +
                    "</span></div>");

                // Add the extra metadata
                lst.push("<div class='metadata'>");

                // Status
                lst.push("<div><span class='grid-heading'>" + apputil.T("label.Status") + ":</span> " +
                    assignment.status + "</div>");

                // Priority
                lst.push("<div><span class='grid-heading'>" + apputil.T("label.Priority") + ":</span> " +
                    "<span class='priority-" + priority.toLowerCase() + "'>" + priority +
                    "</span></div>");

                lst.push("</div>");
                lst.push("</div>");

                // Add the open button
                lst.push("<div class='span2 open-assignment'>");
                lst.push("<a class='btn btn-circle pull-right'>");
                lst.push("<i class='icon-chevron-right'></i></a>");
                lst.push("</div>");

                lst.push("</div>");
                lst.push("</li>");

                $(lst.join(""))
                    .appendTo($("#assignments")).data("assignment", assignment);

                // Clear the list
                lst.length = 0;
            }
        }
    }

    /**
     * ### clearData
     *
     * Clear all assignment data.
     */
    function clearData() {
        // Clear assignment list
        $("#page-title").text(apputil.T("label.Assignments"));
        $("#assignments").html("");
    }

    /**
     * ## Miscellaneous
     * Helper functions for the application.
     */

    /**
     * ### formatPriority
     *
     * Formats the priority into a human-readable format.
     *
     * @param value    The priority value.
     * @return         String representing the priority.
     */
    function formatPriority(value) {
        // Default to medium
        var priority = apputil.T("priority.Medium");

        // Change value based on Content Server values
        if (value < 50) {
            priority = apputil.T("priority.Low");
        } else if (value > 50) {
            priority = apputil.T("priority.High");
        }
        return priority;
    }

    /**
     * ### openAssignment
     *
     * Opens an assignment in its specific viewer.
     *
     * @param data        Data to pass to the component viewer.
     */
    function openAssignment(data) {
        var refreshOnReturn = true;
        var destComponentName = '';

        if (data.type == "task") {
            destComponentName = 'tasks-component';
        } else if (data.type == "workflow") {
            destComponentName = 'workflow-component';
        }

        data.action = 'assignment';

        Assignments.openFromAppworks(destComponentName, data, refreshOnReturn, true);
    }

    // Manually start the application
    Assignments.start();
}).call(this);
