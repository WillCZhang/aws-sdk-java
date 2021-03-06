/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.iot.model;

import java.io.Serializable;
import javax.annotation.Generated;

@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CreateBillingGroupResult extends com.amazonaws.AmazonWebServiceResult<com.amazonaws.ResponseMetadata> implements Serializable, Cloneable {

    /**
     * <p>
     * The name you gave to the billing group.
     * </p>
     */
    private String billingGroupName;
    /**
     * <p>
     * The ARN of the billing group.
     * </p>
     */
    private String billingGroupArn;
    /**
     * <p>
     * The ID of the billing group.
     * </p>
     */
    private String billingGroupId;

    /**
     * <p>
     * The name you gave to the billing group.
     * </p>
     * 
     * @param billingGroupName
     *        The name you gave to the billing group.
     */

    public void setBillingGroupName(String billingGroupName) {
        this.billingGroupName = billingGroupName;
    }

    /**
     * <p>
     * The name you gave to the billing group.
     * </p>
     * 
     * @return The name you gave to the billing group.
     */

    public String getBillingGroupName() {
        return this.billingGroupName;
    }

    /**
     * <p>
     * The name you gave to the billing group.
     * </p>
     * 
     * @param billingGroupName
     *        The name you gave to the billing group.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public CreateBillingGroupResult withBillingGroupName(String billingGroupName) {
        setBillingGroupName(billingGroupName);
        return this;
    }

    /**
     * <p>
     * The ARN of the billing group.
     * </p>
     * 
     * @param billingGroupArn
     *        The ARN of the billing group.
     */

    public void setBillingGroupArn(String billingGroupArn) {
        this.billingGroupArn = billingGroupArn;
    }

    /**
     * <p>
     * The ARN of the billing group.
     * </p>
     * 
     * @return The ARN of the billing group.
     */

    public String getBillingGroupArn() {
        return this.billingGroupArn;
    }

    /**
     * <p>
     * The ARN of the billing group.
     * </p>
     * 
     * @param billingGroupArn
     *        The ARN of the billing group.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public CreateBillingGroupResult withBillingGroupArn(String billingGroupArn) {
        setBillingGroupArn(billingGroupArn);
        return this;
    }

    /**
     * <p>
     * The ID of the billing group.
     * </p>
     * 
     * @param billingGroupId
     *        The ID of the billing group.
     */

    public void setBillingGroupId(String billingGroupId) {
        this.billingGroupId = billingGroupId;
    }

    /**
     * <p>
     * The ID of the billing group.
     * </p>
     * 
     * @return The ID of the billing group.
     */

    public String getBillingGroupId() {
        return this.billingGroupId;
    }

    /**
     * <p>
     * The ID of the billing group.
     * </p>
     * 
     * @param billingGroupId
     *        The ID of the billing group.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public CreateBillingGroupResult withBillingGroupId(String billingGroupId) {
        setBillingGroupId(billingGroupId);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getBillingGroupName() != null)
            sb.append("BillingGroupName: ").append(getBillingGroupName()).append(",");
        if (getBillingGroupArn() != null)
            sb.append("BillingGroupArn: ").append(getBillingGroupArn()).append(",");
        if (getBillingGroupId() != null)
            sb.append("BillingGroupId: ").append(getBillingGroupId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateBillingGroupResult == false)
            return false;
        CreateBillingGroupResult other = (CreateBillingGroupResult) obj;
        if (other.getBillingGroupName() == null ^ this.getBillingGroupName() == null)
            return false;
        if (other.getBillingGroupName() != null && other.getBillingGroupName().equals(this.getBillingGroupName()) == false)
            return false;
        if (other.getBillingGroupArn() == null ^ this.getBillingGroupArn() == null)
            return false;
        if (other.getBillingGroupArn() != null && other.getBillingGroupArn().equals(this.getBillingGroupArn()) == false)
            return false;
        if (other.getBillingGroupId() == null ^ this.getBillingGroupId() == null)
            return false;
        if (other.getBillingGroupId() != null && other.getBillingGroupId().equals(this.getBillingGroupId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getBillingGroupName() == null) ? 0 : getBillingGroupName().hashCode());
        hashCode = prime * hashCode + ((getBillingGroupArn() == null) ? 0 : getBillingGroupArn().hashCode());
        hashCode = prime * hashCode + ((getBillingGroupId() == null) ? 0 : getBillingGroupId().hashCode());
        return hashCode;
    }

    @Override
    public CreateBillingGroupResult clone() {
        try {
            return (CreateBillingGroupResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
