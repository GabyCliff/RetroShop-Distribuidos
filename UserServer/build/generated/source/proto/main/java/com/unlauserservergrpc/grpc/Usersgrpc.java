// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: usersgrpc.proto

package com.unlauserservergrpc.grpc;

public final class Usersgrpc {
  private Usersgrpc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_username_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_username_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserObject_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserObject_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Error_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Error_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseUser_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseUser_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017usersgrpc.proto\"\007\n\005Empty\"\034\n\010username\022\020" +
      "\n\010username\030\001 \001(\t\"^\n\nUserObject\022\020\n\010userna" +
      "me\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\022\014\n\004name\030\003 \001(\t" +
      "\022\017\n\007surname\030\004 \001(\t\022\r\n\005email\030\005 \001(\t\"\034\n\005Erro" +
      "r\022\023\n\013description\030\001 \001(\t\"@\n\014ResponseUser\022\031" +
      "\n\004data\030\001 \001(\0132\013.UserObject\022\025\n\005error\030\002 \001(\013" +
      "2\006.Error2;\n\013userService\022,\n\020getOneByUsern" +
      "ame\022\t.username\032\013.UserObject\"\000B\037\n\033com.unl" +
      "auserservergrpc.grpcP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_username_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_username_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_username_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_UserObject_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_UserObject_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserObject_descriptor,
        new java.lang.String[] { "Username", "Password", "Name", "Surname", "Email", });
    internal_static_Error_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Error_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Error_descriptor,
        new java.lang.String[] { "Description", });
    internal_static_ResponseUser_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ResponseUser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseUser_descriptor,
        new java.lang.String[] { "Data", "Error", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}