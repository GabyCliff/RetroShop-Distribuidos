// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: retroShop_grpc.proto

package com.unla.retroshopservicegrpc.grpc;

/**
 * Protobuf type {@code ResponseObjectVirtualWalletData}
 */
public final class ResponseObjectVirtualWalletData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ResponseObjectVirtualWalletData)
    ResponseObjectVirtualWalletDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResponseObjectVirtualWalletData.newBuilder() to construct.
  private ResponseObjectVirtualWalletData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResponseObjectVirtualWalletData() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResponseObjectVirtualWalletData();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ResponseObjectVirtualWalletData(
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
            com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder subBuilder = null;
            if (virtualWalletResponse_ != null) {
              subBuilder = virtualWalletResponse_.toBuilder();
            }
            virtualWalletResponse_ = input.readMessage(com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(virtualWalletResponse_);
              virtualWalletResponse_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder subBuilder = null;
            if (description_ != null) {
              subBuilder = description_.toBuilder();
            }
            description_ = input.readMessage(com.unla.retroshopservicegrpc.grpc.TransactionMessage.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(description_);
              description_ = subBuilder.buildPartial();
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
    return com.unla.retroshopservicegrpc.grpc.RetroShopGrpc.internal_static_ResponseObjectVirtualWalletData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.unla.retroshopservicegrpc.grpc.RetroShopGrpc.internal_static_ResponseObjectVirtualWalletData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.class, com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.Builder.class);
  }

  public static final int VIRTUALWALLETRESPONSE_FIELD_NUMBER = 1;
  private com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse virtualWalletResponse_;
  /**
   * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
   * @return Whether the virtualWalletResponse field is set.
   */
  @java.lang.Override
  public boolean hasVirtualWalletResponse() {
    return virtualWalletResponse_ != null;
  }
  /**
   * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
   * @return The virtualWalletResponse.
   */
  @java.lang.Override
  public com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse getVirtualWalletResponse() {
    return virtualWalletResponse_ == null ? com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.getDefaultInstance() : virtualWalletResponse_;
  }
  /**
   * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
   */
  @java.lang.Override
  public com.unla.retroshopservicegrpc.grpc.VirtualWalletResponseOrBuilder getVirtualWalletResponseOrBuilder() {
    return getVirtualWalletResponse();
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  private com.unla.retroshopservicegrpc.grpc.TransactionMessage description_;
  /**
   * <code>.TransactionMessage description = 2;</code>
   * @return Whether the description field is set.
   */
  @java.lang.Override
  public boolean hasDescription() {
    return description_ != null;
  }
  /**
   * <code>.TransactionMessage description = 2;</code>
   * @return The description.
   */
  @java.lang.Override
  public com.unla.retroshopservicegrpc.grpc.TransactionMessage getDescription() {
    return description_ == null ? com.unla.retroshopservicegrpc.grpc.TransactionMessage.getDefaultInstance() : description_;
  }
  /**
   * <code>.TransactionMessage description = 2;</code>
   */
  @java.lang.Override
  public com.unla.retroshopservicegrpc.grpc.TransactionMessageOrBuilder getDescriptionOrBuilder() {
    return getDescription();
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
    if (virtualWalletResponse_ != null) {
      output.writeMessage(1, getVirtualWalletResponse());
    }
    if (description_ != null) {
      output.writeMessage(2, getDescription());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (virtualWalletResponse_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getVirtualWalletResponse());
    }
    if (description_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDescription());
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
    if (!(obj instanceof com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData)) {
      return super.equals(obj);
    }
    com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData other = (com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData) obj;

    if (hasVirtualWalletResponse() != other.hasVirtualWalletResponse()) return false;
    if (hasVirtualWalletResponse()) {
      if (!getVirtualWalletResponse()
          .equals(other.getVirtualWalletResponse())) return false;
    }
    if (hasDescription() != other.hasDescription()) return false;
    if (hasDescription()) {
      if (!getDescription()
          .equals(other.getDescription())) return false;
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
    if (hasVirtualWalletResponse()) {
      hash = (37 * hash) + VIRTUALWALLETRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getVirtualWalletResponse().hashCode();
    }
    if (hasDescription()) {
      hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getDescription().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parseFrom(
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
  public static Builder newBuilder(com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData prototype) {
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
   * Protobuf type {@code ResponseObjectVirtualWalletData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ResponseObjectVirtualWalletData)
      com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.unla.retroshopservicegrpc.grpc.RetroShopGrpc.internal_static_ResponseObjectVirtualWalletData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.unla.retroshopservicegrpc.grpc.RetroShopGrpc.internal_static_ResponseObjectVirtualWalletData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.class, com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.Builder.class);
    }

    // Construct using com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.newBuilder()
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
      if (virtualWalletResponseBuilder_ == null) {
        virtualWalletResponse_ = null;
      } else {
        virtualWalletResponse_ = null;
        virtualWalletResponseBuilder_ = null;
      }
      if (descriptionBuilder_ == null) {
        description_ = null;
      } else {
        description_ = null;
        descriptionBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.unla.retroshopservicegrpc.grpc.RetroShopGrpc.internal_static_ResponseObjectVirtualWalletData_descriptor;
    }

    @java.lang.Override
    public com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData getDefaultInstanceForType() {
      return com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance();
    }

    @java.lang.Override
    public com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData build() {
      com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData buildPartial() {
      com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData result = new com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData(this);
      if (virtualWalletResponseBuilder_ == null) {
        result.virtualWalletResponse_ = virtualWalletResponse_;
      } else {
        result.virtualWalletResponse_ = virtualWalletResponseBuilder_.build();
      }
      if (descriptionBuilder_ == null) {
        result.description_ = description_;
      } else {
        result.description_ = descriptionBuilder_.build();
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
      if (other instanceof com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData) {
        return mergeFrom((com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData other) {
      if (other == com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData.getDefaultInstance()) return this;
      if (other.hasVirtualWalletResponse()) {
        mergeVirtualWalletResponse(other.getVirtualWalletResponse());
      }
      if (other.hasDescription()) {
        mergeDescription(other.getDescription());
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
      com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse virtualWalletResponse_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponseOrBuilder> virtualWalletResponseBuilder_;
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     * @return Whether the virtualWalletResponse field is set.
     */
    public boolean hasVirtualWalletResponse() {
      return virtualWalletResponseBuilder_ != null || virtualWalletResponse_ != null;
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     * @return The virtualWalletResponse.
     */
    public com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse getVirtualWalletResponse() {
      if (virtualWalletResponseBuilder_ == null) {
        return virtualWalletResponse_ == null ? com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.getDefaultInstance() : virtualWalletResponse_;
      } else {
        return virtualWalletResponseBuilder_.getMessage();
      }
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public Builder setVirtualWalletResponse(com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse value) {
      if (virtualWalletResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        virtualWalletResponse_ = value;
        onChanged();
      } else {
        virtualWalletResponseBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public Builder setVirtualWalletResponse(
        com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder builderForValue) {
      if (virtualWalletResponseBuilder_ == null) {
        virtualWalletResponse_ = builderForValue.build();
        onChanged();
      } else {
        virtualWalletResponseBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public Builder mergeVirtualWalletResponse(com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse value) {
      if (virtualWalletResponseBuilder_ == null) {
        if (virtualWalletResponse_ != null) {
          virtualWalletResponse_ =
            com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.newBuilder(virtualWalletResponse_).mergeFrom(value).buildPartial();
        } else {
          virtualWalletResponse_ = value;
        }
        onChanged();
      } else {
        virtualWalletResponseBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public Builder clearVirtualWalletResponse() {
      if (virtualWalletResponseBuilder_ == null) {
        virtualWalletResponse_ = null;
        onChanged();
      } else {
        virtualWalletResponse_ = null;
        virtualWalletResponseBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder getVirtualWalletResponseBuilder() {
      
      onChanged();
      return getVirtualWalletResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    public com.unla.retroshopservicegrpc.grpc.VirtualWalletResponseOrBuilder getVirtualWalletResponseOrBuilder() {
      if (virtualWalletResponseBuilder_ != null) {
        return virtualWalletResponseBuilder_.getMessageOrBuilder();
      } else {
        return virtualWalletResponse_ == null ?
            com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.getDefaultInstance() : virtualWalletResponse_;
      }
    }
    /**
     * <code>.VirtualWalletResponse virtualWalletResponse = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponseOrBuilder> 
        getVirtualWalletResponseFieldBuilder() {
      if (virtualWalletResponseBuilder_ == null) {
        virtualWalletResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponse.Builder, com.unla.retroshopservicegrpc.grpc.VirtualWalletResponseOrBuilder>(
                getVirtualWalletResponse(),
                getParentForChildren(),
                isClean());
        virtualWalletResponse_ = null;
      }
      return virtualWalletResponseBuilder_;
    }

    private com.unla.retroshopservicegrpc.grpc.TransactionMessage description_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unla.retroshopservicegrpc.grpc.TransactionMessage, com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder, com.unla.retroshopservicegrpc.grpc.TransactionMessageOrBuilder> descriptionBuilder_;
    /**
     * <code>.TransactionMessage description = 2;</code>
     * @return Whether the description field is set.
     */
    public boolean hasDescription() {
      return descriptionBuilder_ != null || description_ != null;
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     * @return The description.
     */
    public com.unla.retroshopservicegrpc.grpc.TransactionMessage getDescription() {
      if (descriptionBuilder_ == null) {
        return description_ == null ? com.unla.retroshopservicegrpc.grpc.TransactionMessage.getDefaultInstance() : description_;
      } else {
        return descriptionBuilder_.getMessage();
      }
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public Builder setDescription(com.unla.retroshopservicegrpc.grpc.TransactionMessage value) {
      if (descriptionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        description_ = value;
        onChanged();
      } else {
        descriptionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public Builder setDescription(
        com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder builderForValue) {
      if (descriptionBuilder_ == null) {
        description_ = builderForValue.build();
        onChanged();
      } else {
        descriptionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public Builder mergeDescription(com.unla.retroshopservicegrpc.grpc.TransactionMessage value) {
      if (descriptionBuilder_ == null) {
        if (description_ != null) {
          description_ =
            com.unla.retroshopservicegrpc.grpc.TransactionMessage.newBuilder(description_).mergeFrom(value).buildPartial();
        } else {
          description_ = value;
        }
        onChanged();
      } else {
        descriptionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public Builder clearDescription() {
      if (descriptionBuilder_ == null) {
        description_ = null;
        onChanged();
      } else {
        description_ = null;
        descriptionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder getDescriptionBuilder() {
      
      onChanged();
      return getDescriptionFieldBuilder().getBuilder();
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    public com.unla.retroshopservicegrpc.grpc.TransactionMessageOrBuilder getDescriptionOrBuilder() {
      if (descriptionBuilder_ != null) {
        return descriptionBuilder_.getMessageOrBuilder();
      } else {
        return description_ == null ?
            com.unla.retroshopservicegrpc.grpc.TransactionMessage.getDefaultInstance() : description_;
      }
    }
    /**
     * <code>.TransactionMessage description = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.unla.retroshopservicegrpc.grpc.TransactionMessage, com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder, com.unla.retroshopservicegrpc.grpc.TransactionMessageOrBuilder> 
        getDescriptionFieldBuilder() {
      if (descriptionBuilder_ == null) {
        descriptionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.unla.retroshopservicegrpc.grpc.TransactionMessage, com.unla.retroshopservicegrpc.grpc.TransactionMessage.Builder, com.unla.retroshopservicegrpc.grpc.TransactionMessageOrBuilder>(
                getDescription(),
                getParentForChildren(),
                isClean());
        description_ = null;
      }
      return descriptionBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ResponseObjectVirtualWalletData)
  }

  // @@protoc_insertion_point(class_scope:ResponseObjectVirtualWalletData)
  private static final com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData();
  }

  public static com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResponseObjectVirtualWalletData>
      PARSER = new com.google.protobuf.AbstractParser<ResponseObjectVirtualWalletData>() {
    @java.lang.Override
    public ResponseObjectVirtualWalletData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ResponseObjectVirtualWalletData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResponseObjectVirtualWalletData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResponseObjectVirtualWalletData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.unla.retroshopservicegrpc.grpc.ResponseObjectVirtualWalletData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

