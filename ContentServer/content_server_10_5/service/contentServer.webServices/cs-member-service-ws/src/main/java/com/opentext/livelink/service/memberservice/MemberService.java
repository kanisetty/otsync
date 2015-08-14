package com.opentext.livelink.service.memberservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-08-13T14:09:42.422-07:00
 * Generated source version: 3.1.2
 * 
 */
@WebService(targetNamespace = "urn:MemberService.service.livelink.opentext.com", name = "MemberService")
@XmlSeeAlso({com.opentext.livelink.service.core.ObjectFactory.class, ObjectFactory.class, com.opentext.ecm.api.ObjectFactory.class})
public interface MemberService {

    @WebMethod(operationName = "GetGroupByName", action = "urn:MemberService.service.livelink.opentext.com/GetGroupByName")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetGroupByName", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetGroupByNameResponse")
    @RequestWrapper(localName = "GetGroupByName", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetGroupByName")
    @ResponseWrapper(localName = "GetGroupByNameResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetGroupByNameResponse")
    @WebResult(name = "GetGroupByNameResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Group getGroupByName(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name
    );

    @WebMethod(operationName = "ConvertExternalUserToUser", action = "urn:MemberService.service.livelink.opentext.com/ConvertExternalUserToUser")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/ConvertExternalUserToUser", output = "urn:MemberService.service.livelink.opentext.com/MemberService/ConvertExternalUserToUserResponse")
    @RequestWrapper(localName = "ConvertExternalUserToUser", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ConvertExternalUserToUser")
    @ResponseWrapper(localName = "ConvertExternalUserToUserResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ConvertExternalUserToUserResponse")
    public void convertExternalUserToUser(
        @WebParam(name = "userID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long userID,
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID,
        @WebParam(name = "memberPrivileges", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.MemberPrivileges memberPrivileges
    );

    @WebMethod(operationName = "GetSearchResults", action = "urn:MemberService.service.livelink.opentext.com/GetSearchResults")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetSearchResults", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetSearchResultsResponse")
    @RequestWrapper(localName = "GetSearchResults", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetSearchResults")
    @ResponseWrapper(localName = "GetSearchResultsResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetSearchResultsResponse")
    @WebResult(name = "GetSearchResultsResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.MemberSearchResults getSearchResults(
        @WebParam(name = "pageHandle", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.core.PageHandle pageHandle
    );

    @WebMethod(operationName = "SearchForMembers", action = "urn:MemberService.service.livelink.opentext.com/SearchForMembers")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/SearchForMembers", output = "urn:MemberService.service.livelink.opentext.com/MemberService/SearchForMembersResponse")
    @RequestWrapper(localName = "SearchForMembers", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.SearchForMembers")
    @ResponseWrapper(localName = "SearchForMembersResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.SearchForMembersResponse")
    @WebResult(name = "SearchForMembersResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.core.PageHandle searchForMembers(
        @WebParam(name = "options", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.MemberSearchOptions options
    );

    @WebMethod(operationName = "CreateExternalUser", action = "urn:MemberService.service.livelink.opentext.com/CreateExternalUser")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateExternalUser", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateExternalUserResponse")
    @RequestWrapper(localName = "CreateExternalUser", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateExternalUser")
    @ResponseWrapper(localName = "CreateExternalUserResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateExternalUserResponse")
    @WebResult(name = "CreateExternalUserResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createExternalUser(
        @WebParam(name = "user", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.User user
    );

    @WebMethod(operationName = "RemoveMemberFromGroup", action = "urn:MemberService.service.livelink.opentext.com/RemoveMemberFromGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/RemoveMemberFromGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/RemoveMemberFromGroupResponse")
    @RequestWrapper(localName = "RemoveMemberFromGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.RemoveMemberFromGroup")
    @ResponseWrapper(localName = "RemoveMemberFromGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.RemoveMemberFromGroupResponse")
    public void removeMemberFromGroup(
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID,
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID
    );

    @WebMethod(operationName = "CreateMember", action = "urn:MemberService.service.livelink.opentext.com/CreateMember")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateMember", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateMemberResponse")
    @RequestWrapper(localName = "CreateMember", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateMember")
    @ResponseWrapper(localName = "CreateMemberResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateMemberResponse")
    @WebResult(name = "CreateMemberResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Member createMember(
        @WebParam(name = "member", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.Member member
    );

    @WebMethod(operationName = "GetMembersByID", action = "urn:MemberService.service.livelink.opentext.com/GetMembersByID")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetMembersByID", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetMembersByIDResponse")
    @RequestWrapper(localName = "GetMembersByID", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMembersByID")
    @ResponseWrapper(localName = "GetMembersByIDResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMembersByIDResponse")
    @WebResult(name = "GetMembersByIDResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public java.util.List<com.opentext.livelink.service.memberservice.Member> getMembersByID(
        @WebParam(name = "memberIDs", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.util.List<java.lang.Long> memberIDs
    );

    @WebMethod(operationName = "RemoveListOfMembersFromGroup", action = "urn:MemberService.service.livelink.opentext.com/RemoveListOfMembersFromGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/RemoveListOfMembersFromGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/RemoveListOfMembersFromGroupResponse")
    @RequestWrapper(localName = "RemoveListOfMembersFromGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.RemoveListOfMembersFromGroup")
    @ResponseWrapper(localName = "RemoveListOfMembersFromGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.RemoveListOfMembersFromGroupResponse")
    public void removeListOfMembersFromGroup(
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID,
        @WebParam(name = "memberIDs", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.util.List<java.lang.Long> memberIDs
    );

    @WebMethod(operationName = "UpdatePassword", action = "urn:MemberService.service.livelink.opentext.com/UpdatePassword")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/UpdatePassword", output = "urn:MemberService.service.livelink.opentext.com/MemberService/UpdatePasswordResponse")
    @RequestWrapper(localName = "UpdatePassword", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.UpdatePassword")
    @ResponseWrapper(localName = "UpdatePasswordResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.UpdatePasswordResponse")
    public void updatePassword(
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID,
        @WebParam(name = "newPassword", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String newPassword,
        @WebParam(name = "oldPassword", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String oldPassword
    );

    @WebMethod(operationName = "UpdateMember", action = "urn:MemberService.service.livelink.opentext.com/UpdateMember")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/UpdateMember", output = "urn:MemberService.service.livelink.opentext.com/MemberService/UpdateMemberResponse")
    @RequestWrapper(localName = "UpdateMember", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.UpdateMember")
    @ResponseWrapper(localName = "UpdateMemberResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.UpdateMemberResponse")
    @WebResult(name = "UpdateMemberResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Member updateMember(
        @WebParam(name = "member", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.Member member
    );

    @WebMethod(operationName = "ListMemberOf", action = "urn:MemberService.service.livelink.opentext.com/ListMemberOf")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/ListMemberOf", output = "urn:MemberService.service.livelink.opentext.com/MemberService/ListMemberOfResponse")
    @RequestWrapper(localName = "ListMemberOf", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListMemberOf")
    @ResponseWrapper(localName = "ListMemberOfResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListMemberOfResponse")
    @WebResult(name = "ListMemberOfResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public java.util.List<com.opentext.livelink.service.memberservice.Group> listMemberOf(
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID
    );

    @WebMethod(operationName = "SetMetadataLanguage", action = "urn:MemberService.service.livelink.opentext.com/SetMetadataLanguage")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/SetMetadataLanguage", output = "urn:MemberService.service.livelink.opentext.com/MemberService/SetMetadataLanguageResponse")
    @RequestWrapper(localName = "SetMetadataLanguage", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.SetMetadataLanguage")
    @ResponseWrapper(localName = "SetMetadataLanguageResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.SetMetadataLanguageResponse")
    public void setMetadataLanguage(
        @WebParam(name = "languageCode", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String languageCode
    );

    @WebMethod(operationName = "GetGroupByNameInDomain", action = "urn:MemberService.service.livelink.opentext.com/GetGroupByNameInDomain")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetGroupByNameInDomain", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetGroupByNameInDomainResponse")
    @RequestWrapper(localName = "GetGroupByNameInDomain", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetGroupByNameInDomain")
    @ResponseWrapper(localName = "GetGroupByNameInDomainResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetGroupByNameInDomainResponse")
    @WebResult(name = "GetGroupByNameInDomainResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Group getGroupByNameInDomain(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name,
        @WebParam(name = "domainID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long domainID
    );

    @WebMethod(operationName = "GetMemberById", action = "urn:MemberService.service.livelink.opentext.com/GetMemberById")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetMemberById", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetMemberByIdResponse")
    @RequestWrapper(localName = "GetMemberById", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMemberById")
    @ResponseWrapper(localName = "GetMemberByIdResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMemberByIdResponse")
    @WebResult(name = "GetMemberByIdResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Member getMemberById(
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID
    );

    @WebMethod(operationName = "AddListOfMembersToGroup", action = "urn:MemberService.service.livelink.opentext.com/AddListOfMembersToGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/AddListOfMembersToGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/AddListOfMembersToGroupResponse")
    @RequestWrapper(localName = "AddListOfMembersToGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.AddListOfMembersToGroup")
    @ResponseWrapper(localName = "AddListOfMembersToGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.AddListOfMembersToGroupResponse")
    public void addListOfMembersToGroup(
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID,
        @WebParam(name = "memberIDs", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.util.List<java.lang.Long> memberIDs
    );

    @WebMethod(operationName = "AddMemberToGroup", action = "urn:MemberService.service.livelink.opentext.com/AddMemberToGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/AddMemberToGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/AddMemberToGroupResponse")
    @RequestWrapper(localName = "AddMemberToGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.AddMemberToGroup")
    @ResponseWrapper(localName = "AddMemberToGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.AddMemberToGroupResponse")
    public void addMemberToGroup(
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID,
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID
    );

    @WebMethod(operationName = "CreateGroupInDomain", action = "urn:MemberService.service.livelink.opentext.com/CreateGroupInDomain")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateGroupInDomain", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateGroupInDomainResponse")
    @RequestWrapper(localName = "CreateGroupInDomain", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateGroupInDomain")
    @ResponseWrapper(localName = "CreateGroupInDomainResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateGroupInDomainResponse")
    @WebResult(name = "CreateGroupInDomainResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createGroupInDomain(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name,
        @WebParam(name = "leaderID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.Long leaderID,
        @WebParam(name = "domainID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long domainID
    );

    @WebMethod(operationName = "GetMemberByLoginName", action = "urn:MemberService.service.livelink.opentext.com/GetMemberByLoginName")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetMemberByLoginName", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetMemberByLoginNameResponse")
    @RequestWrapper(localName = "GetMemberByLoginName", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMemberByLoginName")
    @ResponseWrapper(localName = "GetMemberByLoginNameResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMemberByLoginNameResponse")
    @WebResult(name = "GetMemberByLoginNameResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.Member getMemberByLoginName(
        @WebParam(name = "loginName", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String loginName
    );

    @WebMethod(operationName = "GetMetadataLanguage", action = "urn:MemberService.service.livelink.opentext.com/GetMetadataLanguage")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetMetadataLanguage", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetMetadataLanguageResponse")
    @RequestWrapper(localName = "GetMetadataLanguage", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMetadataLanguage")
    @ResponseWrapper(localName = "GetMetadataLanguageResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetMetadataLanguageResponse")
    @WebResult(name = "GetMetadataLanguageResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public java.lang.String getMetadataLanguage();

    @WebMethod(operationName = "CreateDomain", action = "urn:MemberService.service.livelink.opentext.com/CreateDomain")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateDomain", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateDomainResponse")
    @RequestWrapper(localName = "CreateDomain", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateDomain")
    @ResponseWrapper(localName = "CreateDomainResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateDomainResponse")
    @WebResult(name = "CreateDomainResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createDomain(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name
    );

    @WebMethod(operationName = "CreateGroup", action = "urn:MemberService.service.livelink.opentext.com/CreateGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateGroupResponse")
    @RequestWrapper(localName = "CreateGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateGroup")
    @ResponseWrapper(localName = "CreateGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateGroupResponse")
    @WebResult(name = "CreateGroupResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createGroup(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name,
        @WebParam(name = "leaderID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.Long leaderID
    );

    @WebMethod(operationName = "CreateUser", action = "urn:MemberService.service.livelink.opentext.com/CreateUser")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateUser", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateUserResponse")
    @RequestWrapper(localName = "CreateUser", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateUser")
    @ResponseWrapper(localName = "CreateUserResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateUserResponse")
    @WebResult(name = "CreateUserResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createUser(
        @WebParam(name = "user", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.User user
    );

    @WebMethod(operationName = "GetAuthenticatedUser", action = "urn:MemberService.service.livelink.opentext.com/GetAuthenticatedUser")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetAuthenticatedUser", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetAuthenticatedUserResponse")
    @RequestWrapper(localName = "GetAuthenticatedUser", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetAuthenticatedUser")
    @ResponseWrapper(localName = "GetAuthenticatedUserResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetAuthenticatedUserResponse")
    @WebResult(name = "GetAuthenticatedUserResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.User getAuthenticatedUser();

    @WebMethod(operationName = "ListMembers", action = "urn:MemberService.service.livelink.opentext.com/ListMembers")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/ListMembers", output = "urn:MemberService.service.livelink.opentext.com/MemberService/ListMembersResponse")
    @RequestWrapper(localName = "ListMembers", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListMembers")
    @ResponseWrapper(localName = "ListMembersResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListMembersResponse")
    @WebResult(name = "ListMembersResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public java.util.List<com.opentext.livelink.service.memberservice.Member> listMembers(
        @WebParam(name = "groupID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long groupID
    );

    @WebMethod(operationName = "CreateUserInDomain", action = "urn:MemberService.service.livelink.opentext.com/CreateUserInDomain")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateUserInDomain", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateUserInDomainResponse")
    @RequestWrapper(localName = "CreateUserInDomain", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateUserInDomain")
    @ResponseWrapper(localName = "CreateUserInDomainResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateUserInDomainResponse")
    @WebResult(name = "CreateUserInDomainResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createUserInDomain(
        @WebParam(name = "user", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        com.opentext.livelink.service.memberservice.User user,
        @WebParam(name = "domainID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long domainID
    );

    @WebMethod(operationName = "CreateExternalGroup", action = "urn:MemberService.service.livelink.opentext.com/CreateExternalGroup")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/CreateExternalGroup", output = "urn:MemberService.service.livelink.opentext.com/MemberService/CreateExternalGroupResponse")
    @RequestWrapper(localName = "CreateExternalGroup", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateExternalGroup")
    @ResponseWrapper(localName = "CreateExternalGroupResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.CreateExternalGroupResponse")
    @WebResult(name = "CreateExternalGroupResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public long createExternalGroup(
        @WebParam(name = "name", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String name,
        @WebParam(name = "leaderID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.Long leaderID
    );

    @WebMethod(operationName = "DeleteMember", action = "urn:MemberService.service.livelink.opentext.com/DeleteMember")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/DeleteMember", output = "urn:MemberService.service.livelink.opentext.com/MemberService/DeleteMemberResponse")
    @RequestWrapper(localName = "DeleteMember", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.DeleteMember")
    @ResponseWrapper(localName = "DeleteMemberResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.DeleteMemberResponse")
    public void deleteMember(
        @WebParam(name = "memberID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long memberID
    );

    @WebMethod(operationName = "DeleteListOfMembers", action = "urn:MemberService.service.livelink.opentext.com/DeleteListOfMembers")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/DeleteListOfMembers", output = "urn:MemberService.service.livelink.opentext.com/MemberService/DeleteListOfMembersResponse")
    @RequestWrapper(localName = "DeleteListOfMembers", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.DeleteListOfMembers")
    @ResponseWrapper(localName = "DeleteListOfMembersResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.DeleteListOfMembersResponse")
    public void deleteListOfMembers(
        @WebParam(name = "memberIDs", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.util.List<java.lang.Long> memberIDs
    );

    @WebMethod(operationName = "GetUserByLoginName", action = "urn:MemberService.service.livelink.opentext.com/GetUserByLoginName")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetUserByLoginName", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetUserByLoginNameResponse")
    @RequestWrapper(localName = "GetUserByLoginName", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetUserByLoginName")
    @ResponseWrapper(localName = "GetUserByLoginNameResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetUserByLoginNameResponse")
    @WebResult(name = "GetUserByLoginNameResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.User getUserByLoginName(
        @WebParam(name = "loginName", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String loginName
    );

    @WebMethod(operationName = "GetUserByLoginNameInDomain", action = "urn:MemberService.service.livelink.opentext.com/GetUserByLoginNameInDomain")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/GetUserByLoginNameInDomain", output = "urn:MemberService.service.livelink.opentext.com/MemberService/GetUserByLoginNameInDomainResponse")
    @RequestWrapper(localName = "GetUserByLoginNameInDomain", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetUserByLoginNameInDomain")
    @ResponseWrapper(localName = "GetUserByLoginNameInDomainResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.GetUserByLoginNameInDomainResponse")
    @WebResult(name = "GetUserByLoginNameInDomainResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public com.opentext.livelink.service.memberservice.User getUserByLoginNameInDomain(
        @WebParam(name = "loginName", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        java.lang.String loginName,
        @WebParam(name = "domainID", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long domainID
    );

    @WebMethod(operationName = "ListRightsByID", action = "urn:MemberService.service.livelink.opentext.com/ListRightsByID")
    @Action(input = "urn:MemberService.service.livelink.opentext.com/ListRightsByID", output = "urn:MemberService.service.livelink.opentext.com/MemberService/ListRightsByIDResponse")
    @RequestWrapper(localName = "ListRightsByID", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListRightsByID")
    @ResponseWrapper(localName = "ListRightsByIDResponse", targetNamespace = "urn:MemberService.service.livelink.opentext.com", className = "com.opentext.livelink.service.memberservice.ListRightsByIDResponse")
    @WebResult(name = "ListRightsByIDResult", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
    public java.util.List<com.opentext.livelink.service.memberservice.MemberRight> listRightsByID(
        @WebParam(name = "id", targetNamespace = "urn:MemberService.service.livelink.opentext.com")
        long id
    );
}