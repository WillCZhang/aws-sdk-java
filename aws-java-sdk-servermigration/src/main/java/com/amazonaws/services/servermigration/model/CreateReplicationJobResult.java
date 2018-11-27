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
package com.amazonaws.services.servermigration.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/sms-2016-10-24/CreateReplicationJob" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class CreateReplicationJobResult extends com.amazonaws.AmazonWebServiceResult<com.amazonaws.ResponseMetadata> implements Serializable, Cloneable {

    /**
     * <p>
     * The unique identifier of the replication job.
     * </p>
     */
    private String replicationJobId;

    /**
     * <p>
     * The unique identifier of the replication job.
     * </p>
     * 
     * @param replicationJobId
     *        The unique identifier of the replication job.
     */

    public void setReplicationJobId(String replicationJobId) {
        this.replicationJobId = replicationJobId;
    }

    /**
     * <p>
     * The unique identifier of the replication job.
     * </p>
     * 
     * @return The unique identifier of the replication job.
     */

    public String getReplicationJobId() {
        return this.replicationJobId;
    }

    /**
     * <p>
     * The unique identifier of the replication job.
     * </p>
     * 
     * @param replicationJobId
     *        The unique identifier of the replication job.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public CreateReplicationJobResult withReplicationJobId(String replicationJobId) {
        setReplicationJobId(replicationJobId);
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
        if (getReplicationJobId() != null)
            sb.append("ReplicationJobId: ").append(getReplicationJobId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateReplicationJobResult == false)
            return false;
        CreateReplicationJobResult other = (CreateReplicationJobResult) obj;
        if (other.getReplicationJobId() == null ^ this.getReplicationJobId() == null)
            return false;
        if (other.getReplicationJobId() != null && other.getReplicationJobId().equals(this.getReplicationJobId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getReplicationJobId() == null) ? 0 : getReplicationJobId().hashCode());
        return hashCode;
    }

    @Override
    public CreateReplicationJobResult clone() {
        try {
            return (CreateReplicationJobResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
