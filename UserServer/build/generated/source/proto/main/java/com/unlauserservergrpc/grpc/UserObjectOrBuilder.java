// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: usergrpc.proto

package com.unlauserservergrpc.grpc;

public interface UserResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string username = 2;</code>
   * @return The username.
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 2;</code>
   * @return The bytes for username.
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string name = 3;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 3;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string surname = 4;</code>
   * @return The surname.
   */
  java.lang.String getSurname();
  /**
   * <code>string surname = 4;</code>
   * @return The bytes for surname.
   */
  com.google.protobuf.ByteString
      getSurnameBytes();

  /**
   * <code>int32 dni = 5;</code>
   * @return The dni.
   */
  int getDni();

  /**
   * <code>string email = 6;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 6;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string role = 7;</code>
   * @return The role.
   */
  java.lang.String getRole();
  /**
   * <code>string role = 7;</code>
   * @return The bytes for role.
   */
  com.google.protobuf.ByteString
      getRoleBytes();
}
