/*
 * Copyright 2013-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.ec2.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceResult;

/**
 * 
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DescribeTransitGatewayVpcAttachmentsResult extends com.amazonaws.AmazonWebServiceResult<com.amazonaws.ResponseMetadata> implements Serializable,
        Cloneable {

    /**
     * <p>
     * Information about the VPC attachments.
     * </p>
     */
    private com.amazonaws.internal.SdkInternalList<TransitGatewayVpcAttachment> transitGatewayVpcAttachments;
    /**
     * <p>
     * The token to use to retrieve the next page of results. This value is <code>null</code> when there are no more
     * results to return.
     * </p>
     */
    private String nextToken;

    /**
     * <p>
     * Information about the VPC attachments.
     * </p>
     * 
     * @return Information about the VPC attachments.
     */

    public java.util.List<TransitGatewayVpcAttachment> getTransitGatewayVpcAttachments() {
        if (transitGatewayVpcAttachments == null) {
            transitGatewayVpcAttachments = new com.amazonaws.internal.SdkInternalList<TransitGatewayVpcAttachment>();
        }
        return transitGatewayVpcAttachments;
    }

    /**
     * <p>
     * Information about the VPC attachments.
     * </p>
     * 
     * @param transitGatewayVpcAttachments
     *        Information about the VPC attachments.
     */

    public void setTransitGatewayVpcAttachments(java.util.Collection<TransitGatewayVpcAttachment> transitGatewayVpcAttachments) {
        if (transitGatewayVpcAttachments == null) {
            this.transitGatewayVpcAttachments = null;
            return;
        }

        this.transitGatewayVpcAttachments = new com.amazonaws.internal.SdkInternalList<TransitGatewayVpcAttachment>(transitGatewayVpcAttachments);
    }

    /**
     * <p>
     * Information about the VPC attachments.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setTransitGatewayVpcAttachments(java.util.Collection)} or
     * {@link #withTransitGatewayVpcAttachments(java.util.Collection)} if you want to override the existing values.
     * </p>
     * 
     * @param transitGatewayVpcAttachments
     *        Information about the VPC attachments.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeTransitGatewayVpcAttachmentsResult withTransitGatewayVpcAttachments(TransitGatewayVpcAttachment... transitGatewayVpcAttachments) {
        if (this.transitGatewayVpcAttachments == null) {
            setTransitGatewayVpcAttachments(new com.amazonaws.internal.SdkInternalList<TransitGatewayVpcAttachment>(transitGatewayVpcAttachments.length));
        }
        for (TransitGatewayVpcAttachment ele : transitGatewayVpcAttachments) {
            this.transitGatewayVpcAttachments.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * Information about the VPC attachments.
     * </p>
     * 
     * @param transitGatewayVpcAttachments
     *        Information about the VPC attachments.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeTransitGatewayVpcAttachmentsResult withTransitGatewayVpcAttachments(
            java.util.Collection<TransitGatewayVpcAttachment> transitGatewayVpcAttachments) {
        setTransitGatewayVpcAttachments(transitGatewayVpcAttachments);
        return this;
    }

    /**
     * <p>
     * The token to use to retrieve the next page of results. This value is <code>null</code> when there are no more
     * results to return.
     * </p>
     * 
     * @param nextToken
     *        The token to use to retrieve the next page of results. This value is <code>null</code> when there are no
     *        more results to return.
     */

    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * <p>
     * The token to use to retrieve the next page of results. This value is <code>null</code> when there are no more
     * results to return.
     * </p>
     * 
     * @return The token to use to retrieve the next page of results. This value is <code>null</code> when there are no
     *         more results to return.
     */

    public String getNextToken() {
        return this.nextToken;
    }

    /**
     * <p>
     * The token to use to retrieve the next page of results. This value is <code>null</code> when there are no more
     * results to return.
     * </p>
     * 
     * @param nextToken
     *        The token to use to retrieve the next page of results. This value is <code>null</code> when there are no
     *        more results to return.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DescribeTransitGatewayVpcAttachmentsResult withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTransitGatewayVpcAttachments() != null)
            sb.append("TransitGatewayVpcAttachments: ").append(getTransitGatewayVpcAttachments()).append(",");
        if (getNextToken() != null)
            sb.append("NextToken: ").append(getNextToken());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeTransitGatewayVpcAttachmentsResult == false)
            return false;
        DescribeTransitGatewayVpcAttachmentsResult other = (DescribeTransitGatewayVpcAttachmentsResult) obj;
        if (other.getTransitGatewayVpcAttachments() == null ^ this.getTransitGatewayVpcAttachments() == null)
            return false;
        if (other.getTransitGatewayVpcAttachments() != null && other.getTransitGatewayVpcAttachments().equals(this.getTransitGatewayVpcAttachments()) == false)
            return false;
        if (other.getNextToken() == null ^ this.getNextToken() == null)
            return false;
        if (other.getNextToken() != null && other.getNextToken().equals(this.getNextToken()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getTransitGatewayVpcAttachments() == null) ? 0 : getTransitGatewayVpcAttachments().hashCode());
        hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        return hashCode;
    }

    @Override
    public DescribeTransitGatewayVpcAttachmentsResult clone() {
        try {
            return (DescribeTransitGatewayVpcAttachmentsResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
