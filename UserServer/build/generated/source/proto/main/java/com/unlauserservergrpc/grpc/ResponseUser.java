// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: usersgrpc.proto

package com.unlauserservergrpc.grpc;

/**
 * Protobuf type {@code ResponseUser}
 */
public final class ResponseUser extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ResponseUser)
    ResponseUserOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResponseUser.newBuilder() to construct.
  private ResponseUser(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResponseUser() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResponseUser();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ResponseUser(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.unlauserservergrpc.grpc.UserObject.Builder subBuilder = null;
            if (data_ != null) {
              subBuilder = data_.toBuilder();
            }
            data_ = input.readMessage(com.unlauserservergrpc.grpc.UserObject.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(data_);
              data_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.unlauserservergrpc.grpc.Error.Builder subBuilder = null;
            if (error_ != null) {
              subBuilder = error_.toBuilder();
            }
            error_ = input.readMessage(com.unlauserservergrpc.grpc.Error.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(error_);
              error_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.unlauserservergrpc.grpc.Usersgrpc.internal_static_ResponseUser_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.unlauserservergrpc.grpc.Usersgrpc.internal_static_ResponseUser_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.unlauserservergrpc.grpc.ResponseUser.class, com.unlauserservergrpc.grpc.ResponseUser.Builder.class);
  }

  public static final int DATA_FIELD_NUMBER = 1;
  private com.unlauserservergrpc.grpc.UserObject data_;
  /**
   * <code>.UserObject data = 1;</code>
   * @return Whether the data field is set.
   */
  @java.lang.Override
  public boolean hasData() {
    return data_ != null;
  }
  /**
   * <code>.UserObject data = 1;</code>
   * @return The data.
   */
  @java.lang.Override
  public com.unlauserservergrpc.grpc.UserObject getData() {
    return data_ == null ? com.unlauserservergrpc.grpc.UserObject.getDefaultInstance() : data_;
  }
  /**
   * <code>.UserObject data = 1;</code>
   */
  @java.lang.Override
  public com.unlauserservergrpc.grpc.UserObjectOrBuilder getDataOrBuilder() {
    return getData();
  }

  public static final int ERROR_FIELD_NUMBER = 2;
  private com.unlauserservergrpc.grpc.Error error_;
  /**
   * <code>.Error error = 2;</code>
   * @return Whether the error field is set.
   */
  @java.lang.Override
  public boolean hasError() {
    return error_ != null;
  }
  /**
   * <code>.Error error = 2;</code>
   * @return The error.
   */
  @java.lang.Override
  public com.unlauserservergrpc.grpc.Error getError() {
    return error_ == null ? com.unlauserservergrpc.grpc.Error.getDefaultInstance() : error_;
  }
  /**
   * <code>.Error error = 2;</code>
   */
  @java.lang.Override
  public com.unlauserservergrpc.grpc.ErrorOrBuilder getErrorOrBuilder() {
    return getError();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (data_ != null) {
      output.writeMessage(1, getData());
    }
    if (error_ != null) {
      output.writeMessage(2, getError());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (data_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getData());
    }
    if (error_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getError());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.unlauserservergrpc.grpc.ResponseUser)) {
      return super.equals(obj);
    }
    com.unlauserservergrpc.grpc.ResponseUser other = (com.unlauserservergrpc.grpc.ResponseUser) obj;

    if (hasData() != other.hasData()) return false;
    if (hasData()) {
      if (!getData()
          .equals(other.getData())) return false;
    }
    if (hasError() != other.hasError()) return false;
    if (hasError()) {
      if (!getError()
          .equals(other.getError())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasData()) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
    }
    if (hasError()) {
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + getError().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.unlauserservergrpc.grpc.ResponseUser parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.unlauserservergrpc.grpc.ResponseUser prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ResponseUser}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ResponseUser)
      com.unlauserservergrpc.grpc.ResponseUserOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.unlauserservergrpc.grpc.Usersgrpc.internal_static_ResponseUser_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.unlauserservergrpc.grpc.Usersgrpc.internal_static_ResponseUser_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.unlauserservergrpc.grpc.ResponseUser.class, com.unlauserservergrpc.grpc.ResponseUser.Builder.class);
    }

    // Construct using com.unlauserservergrpc.grpc.ResponseUser.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (dataBuilder_ == null) {
        data_ = null;
      } else {
        data_ = null;
        dataBuilder_ = null;
      }
      if (errorBuilder_ == null) {
        error_ = null;
      } else {
        error_ = null;
        errorBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.unlauserservergrpc.grpc.Usersgrpc.internal_static_ResponseUser_descriptor;
    }

    @java.lang.Override
    public com.unlauserservergrpc.grpc.ResponseUser getDefaultInstanceForType() {
      return com.unlauserservergrpc.grpc.ResponseUser.getDefaultInstance();
    }

    @java.lang.Override
    public com.unlauserservergrpc.grpc.ResponseUser build() {
      com.unlauserservergrpc.grpc.ResponseUser result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.unlauserservergrpc.grpc.ResponseUser buildPartial() {
      com.unlauserservergrpc.grpc.ResponseUser result = new com.unlauserservergrpc.grpc.ResponseUser(this);
      if (dataBuilder_ == null) {
        result.data_ = data_;
      } else {
        result.data_ = dataBuilder_.build();
      }
      if (errorBuilder_ == null) {
        result.error_ = error_;
      } else {
        result.error_ = errorBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.unlauserservergrpc.grpc.ResponseUser) {
        return mergeFrom((com.unlauserservergrpc.grpc.ResponseUser)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.unlauserservergrpc.grpc.ResponseUser other) {
      if (other == com.unlauserservergrpc.grpc.ResponseUser.getDefaultInstance()) return this;
      if (other.hasData()) {
        mergeData(other.getData());
      }
      if (other.hasError()) {
        mergeError(other.getError());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.unlauserservergrpc.grpc.ResponseUser parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.unlauserservergrpc.grpc.ResponseUser) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.unlauserservergrpc.grpc.UserObject data_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unlauserservergrpc.grpc.UserObject, com.unlauserservergrpc.grpc.UserObject.Builder, com.unlauserservergrpc.grpc.UserObjectOrBuilder> dataBuilder_;
    /**
     * <code>.UserObject data = 1;</code>
     * @return Whether the data field is set.
     */
    public boolean hasData() {
      return dataBuilder_ != null || data_ != null;
    }
    /**
     * <code>.UserObject data = 1;</code>
     * @return The data.
     */
    public com.unlauserservergrpc.grpc.UserObject getData() {
      if (dataBuilder_ == null) {
        return data_ == null ? com.unlauserservergrpc.grpc.UserObject.getDefaultInstance() : data_;
      } else {
        return dataBuilder_.getMessage();
      }
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public Builder setData(com.unlauserservergrpc.grpc.UserObject value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        data_ = value;
        onChanged();
      } else {
        dataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public Builder setData(
        com.unlauserservergrpc.grpc.UserObject.Builder builderForValue) {
      if (dataBuilder_ == null) {
        data_ = builderForValue.build();
        onChanged();
      } else {
        dataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public Builder mergeData(com.unlauserservergrpc.grpc.UserObject value) {
      if (dataBuilder_ == null) {
        if (data_ != null) {
          data_ =
            com.unlauserservergrpc.grpc.UserObject.newBuilder(data_).mergeFrom(value).buildPartial();
        } else {
          data_ = value;
        }
        onChanged();
      } else {
        dataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public Builder clearData() {
      if (dataBuilder_ == null) {
        data_ = null;
        onChanged();
      } else {
        data_ = null;
        dataBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public com.unlauserservergrpc.grpc.UserObject.Builder getDataBuilder() {
      
      onChanged();
      return getDataFieldBuilder().getBuilder();
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    public com.unlauserservergrpc.grpc.UserObjectOrBuilder getDataOrBuilder() {
      if (dataBuilder_ != null) {
        return dataBuilder_.getMessageOrBuilder();
      } else {
        return data_ == null ?
            com.unlauserservergrpc.grpc.UserObject.getDefaultInstance() : data_;
      }
    }
    /**
     * <code>.UserObject data = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unlauserservergrpc.grpc.UserObject, com.unlauserservergrpc.grpc.UserObject.Builder, com.unlauserservergrpc.grpc.UserObjectOrBuilder> 
        getDataFieldBuilder() {
      if (dataBuilder_ == null) {
        dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.unlauserservergrpc.grpc.UserObject, com.unlauserservergrpc.grpc.UserObject.Builder, com.unlauserservergrpc.grpc.UserObjectOrBuilder>(
                getData(),
                getParentForChildren(),
                isClean());
        data_ = null;
      }
      return dataBuilder_;
    }

    private com.unlauserservergrpc.grpc.Error error_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unlauserservergrpc.grpc.Error, com.unlauserservergrpc.grpc.Error.Builder, com.unlauserservergrpc.grpc.ErrorOrBuilder> errorBuilder_;
    /**
     * <code>.Error error = 2;</code>
     * @return Whether the error field is set.
     */
    public boolean hasError() {
      return errorBuilder_ != null || error_ != null;
    }
    /**
     * <code>.Error error = 2;</code>
     * @return The error.
     */
    public com.unlauserservergrpc.grpc.Error getError() {
      if (errorBuilder_ == null) {
        return error_ == null ? com.unlauserservergrpc.grpc.Error.getDefaultInstance() : error_;
      } else {
        return errorBuilder_.getMessage();
      }
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public Builder setError(com.unlauserservergrpc.grpc.Error value) {
      if (errorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        error_ = value;
        onChanged();
      } else {
        errorBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public Builder setError(
        com.unlauserservergrpc.grpc.Error.Builder builderForValue) {
      if (errorBuilder_ == null) {
        error_ = builderForValue.build();
        onChanged();
      } else {
        errorBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public Builder mergeError(com.unlauserservergrpc.grpc.Error value) {
      if (errorBuilder_ == null) {
        if (error_ != null) {
          error_ =
            com.unlauserservergrpc.grpc.Error.newBuilder(error_).mergeFrom(value).buildPartial();
        } else {
          error_ = value;
        }
        onChanged();
      } else {
        errorBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public Builder clearError() {
      if (errorBuilder_ == null) {
        error_ = null;
        onChanged();
      } else {
        error_ = null;
        errorBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public com.unlauserservergrpc.grpc.Error.Builder getErrorBuilder() {
      
      onChanged();
      return getErrorFieldBuilder().getBuilder();
    }
    /**
     * <code>.Error error = 2;</code>
     */
    public com.unlauserservergrpc.grpc.ErrorOrBuilder getErrorOrBuilder() {
      if (errorBuilder_ != null) {
        return errorBuilder_.getMessageOrBuilder();
      } else {
        return error_ == null ?
            com.unlauserservergrpc.grpc.Error.getDefaultInstance() : error_;
      }
    }
    /**
     * <code>.Error error = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unlauserservergrpc.grpc.Error, com.unlauserservergrpc.grpc.Error.Builder, com.unlauserservergrpc.grpc.ErrorOrBuilder> 
        getErrorFieldBuilder() {
      if (errorBuilder_ == null) {
        errorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.unlauserservergrpc.grpc.Error, com.unlauserservergrpc.grpc.Error.Builder, com.unlauserservergrpc.grpc.ErrorOrBuilder>(
                getError(),
                getParentForChildren(),
                isClean());
        error_ = null;
      }
      return errorBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ResponseUser)
  }

  // @@protoc_insertion_point(class_scope:ResponseUser)
  private static final com.unlauserservergrpc.grpc.ResponseUser DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.unlauserservergrpc.grpc.ResponseUser();
  }

  public static com.unlauserservergrpc.grpc.ResponseUser getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResponseUser>
      PARSER = new com.google.protobuf.AbstractParser<ResponseUser>() {
    @java.lang.Override
    public ResponseUser parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ResponseUser(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResponseUser> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResponseUser> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.unlauserservergrpc.grpc.ResponseUser getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
