package com.opentext.otsync.feeds.rest;

import com.opentext.otsync.api.CSMultiPartRequest;
import com.opentext.otsync.api.CSRequest;
import com.opentext.otsync.rest.util.CSForwardHeaders;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Path("nodes")
@Produces(MediaType.APPLICATION_JSON)
public class NodesResource {

    private static final Log LOG = LogFactory.getLog(NodesResource.class);

    @GET
    @Path("{provider}/{nodeID}")
    public Response getFeedForObject(@QueryParam("before") FeedsResource.Bookmark before,
                                     @QueryParam("after") FeedsResource.Bookmark after,
                                     @QueryParam("count") @DefaultValue("20") int count,
                                     @QueryParam("isRecursive") @DefaultValue("false") boolean isRecursive,
                                     @PathParam("provider") FeedItem.Provider provider,
                                     @PathParam("nodeID") String nodeID,
                                     @Context HttpServletRequest request) {

        FeedsResource.Feed feed = new FeedGetter(before, after, count, new CSForwardHeaders(request))
                .setNodeID(nodeID)
                .setRecursive(isRecursive)
                .setProvider(provider)
                .getFeed();

        return Response.ok(feed).build();
    }

    @POST
    @Path("{provider}/{nodeId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public StreamingOutput postCommentOnNodePlain(@FormParam("status") String status,
                                                  @PathParam("provider") FeedItem.Provider provider,
                                                  @PathParam("nodeId") long nodeId,
                                                  @Context HttpServletRequest request) {
        List<NameValuePair> params = new ArrayList<>(5);
        params.add(new BasicNameValuePair("status", status));
        params.add(new BasicNameValuePair("in_comment_on_obj_id", Long.toString(nodeId)));
        return new CSRequest(FeedsService.getCsUrl(), FeedsResource.POST_STATUS_FUNC,
                params, new CSForwardHeaders(request));
    }

    @POST
    @Path("{provider}/{nodeId}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public StreamingOutput postCommentOnNodeWithAttachment(@FormDataParam("status") String status,
                                                           @FormDataParam("file") InputStream inputStream,
                                                           @FormDataParam("file") FormDataContentDisposition fileInfo,
                                                           @PathParam("provider") FeedItem.Provider provider,
                                                           @PathParam("nodeId") long nodeId,
                                                           @Context HttpServletRequest request) {

        List<NameValuePair> params = new ArrayList<>(5);
        params.add(new BasicNameValuePair("status", status));
        params.add(new BasicNameValuePair("in_comment_on_obj_id", Long.toString(nodeId)));

        String csUrl = FeedsService.getCsUrl();

        if (fileInfo != null) {
            String filename = fileInfo.getFileName();
            if (filename != null) {
                return new CSMultiPartRequest(csUrl, FeedsResource.POST_STATUS_FUNC, params,
                        inputStream, "AddDesktopDoc", filename,
                        new CSForwardHeaders(request));
            } else {
                throw new WebApplicationException(Status.BAD_REQUEST);
            }
        } else {
            return new CSRequest(csUrl, FeedsResource.POST_STATUS_FUNC,
                    params, new CSForwardHeaders(request));
        }
    }

}
