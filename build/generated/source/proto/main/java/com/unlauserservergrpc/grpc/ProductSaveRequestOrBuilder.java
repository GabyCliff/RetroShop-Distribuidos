// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: productgrpc.proto

package com.unlauserservergrpc.grpc;

public interface ProductSaveRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ProductSaveRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string description = 2;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 2;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   *google.protobuf.Timestamp date = 3;
   * </pre>
   *
   * <code>repeated string listPhoto = 4;</code>
   * @return A list containing the listPhoto.
   */
  java.util.List<java.lang.String>
      getListPhotoList();
  /**
   * <pre>
   *google.protobuf.Timestamp date = 3;
   * </pre>
   *
   * <code>repeated string listPhoto = 4;</code>
   * @return The count of listPhoto.
   */
  int getListPhotoCount();
  /**
   * <pre>
   *google.protobuf.Timestamp date = 3;
   * </pre>
   *
   * <code>repeated string listPhoto = 4;</code>
   * @param index The index of the element to return.
   * @return The listPhoto at the given index.
   */
  java.lang.String getListPhoto(int index);
  /**
   * <pre>
   *google.protobuf.Timestamp date = 3;
   * </pre>
   *
   * <code>repeated string listPhoto = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the listPhoto at the given index.
   */
  com.google.protobuf.ByteString
      getListPhotoBytes(int index);

  /**
   * <code>float price = 5;</code>
   * @return The price.
   */
  float getPrice();

  /**
   * <code>int32 available = 6;</code>
   * @return The available.
   */
  int getAvailable();
}
