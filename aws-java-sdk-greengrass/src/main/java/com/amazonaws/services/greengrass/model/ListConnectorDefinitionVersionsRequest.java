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
package com.amazonaws.services.greengrass.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/greengrass-2017-06-07/ListConnectorDefinitionVersions"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ListConnectorDefinitionVersionsRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /** The ID of the connector definition. */
    private String connectorDefinitionId;
    /** The maximum number of results to be returned per request. */
    private String maxResults;
    /** The token for the next set of results, or ''null'' if there are no additional results. */
    private String nextToken;

    /**
     * The ID of the connector definition.
     * 
     * @param connectorDefinitionId
     *        The ID of the connector definition.
     */

    public void setConnectorDefinitionId(String connectorDefinitionId) {
        this.connectorDefinitionId = connectorDefinitionId;
    }

    /**
     * The ID of the connector definition.
     * 
     * @return The ID of the connector definition.
     */

    public String getConnectorDefinitionId() {
        return this.connectorDefinitionId;
    }

    /**
     * The ID of the connector definition.
     * 
     * @param connectorDefinitionId
     *        The ID of the connector definition.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListConnectorDefinitionVersionsRequest withConnectorDefinitionId(String connectorDefinitionId) {
        setConnectorDefinitionId(connectorDefinitionId);
        return this;
    }

    /**
     * The maximum number of results to be returned per request.
     * 
     * @param maxResults
     *        The maximum number of results to be returned per request.
     */

    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * The maximum number of results to be returned per request.
     * 
     * @return The maximum number of results to be returned per request.
     */

    public String getMaxResults() {
        return this.maxResults;
    }

    /**
     * The maximum number of results to be returned per request.
     * 
     * @param maxResults
     *        The maximum number of results to be returned per request.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListConnectorDefinitionVersionsRequest withMaxResults(String maxResults) {
        setMaxResults(maxResults);
        return this;
    }

    /**
     * The token for the next set of results, or ''null'' if there are no additional results.
     * 
     * @param nextToken
     *        The token for the next set of results, or ''null'' if there are no additional results.
     */

    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * The token for the next set of results, or ''null'' if there are no additional results.
     * 
     * @return The token for the next set of results, or ''null'' if there are no additional results.
     */

    public String getNextToken() {
        return this.nextToken;
    }

    /**
     * The token for the next set of results, or ''null'' if there are no additional results.
     * 
     * @param nextToken
     *        The token for the next set of results, or ''null'' if there are no additional results.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListConnectorDefinitionVersionsRequest withNextToken(String nextToken) {
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
        if (getConnectorDefinitionId() != null)
            sb.append("ConnectorDefinitionId: ").append(getConnectorDefinitionId()).append(",");
        if (getMaxResults() != null)
            sb.append("MaxResults: ").append(getMaxResults()).append(",");
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

        if (obj instanceof ListConnectorDefinitionVersionsRequest == false)
            return false;
        ListConnectorDefinitionVersionsRequest other = (ListConnectorDefinitionVersionsRequest) obj;
        if (other.getConnectorDefinitionId() == null ^ this.getConnectorDefinitionId() == null)
            return false;
        if (other.getConnectorDefinitionId() != null && other.getConnectorDefinitionId().equals(this.getConnectorDefinitionId()) == false)
            return false;
        if (other.getMaxResults() == null ^ this.getMaxResults() == null)
            return false;
        if (other.getMaxResults() != null && other.getMaxResults().equals(this.getMaxResults()) == false)
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

        hashCode = prime * hashCode + ((getConnectorDefinitionId() == null) ? 0 : getConnectorDefinitionId().hashCode());
        hashCode = prime * hashCode + ((getMaxResults() == null) ? 0 : getMaxResults().hashCode());
        hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        return hashCode;
    }

    @Override
    public ListConnectorDefinitionVersionsRequest clone() {
        return (ListConnectorDefinitionVersionsRequest) super.clone();
    }

}
