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
package com.amazonaws.services.ec2.model.transform;

import javax.xml.stream.events.XMLEvent;
import javax.annotation.Generated;

import com.amazonaws.services.ec2.model.*;
import com.amazonaws.transform.Unmarshaller;

import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.*;

/**
 * DeleteTransitGatewayResult StAX Unmarshaller
 */

@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DeleteTransitGatewayResultStaxUnmarshaller implements Unmarshaller<DeleteTransitGatewayResult, StaxUnmarshallerContext> {

    public DeleteTransitGatewayResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        DeleteTransitGatewayResult deleteTransitGatewayResult = new DeleteTransitGatewayResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        if (context.isStartOfDocument())
            targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument())
                return deleteTransitGatewayResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {

                if (context.testExpression("transitGateway", targetDepth)) {
                    deleteTransitGatewayResult.setTransitGateway(TransitGatewayStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return deleteTransitGatewayResult;
                }
            }
        }
    }

    private static DeleteTransitGatewayResultStaxUnmarshaller instance;

    public static DeleteTransitGatewayResultStaxUnmarshaller getInstance() {
        if (instance == null)
            instance = new DeleteTransitGatewayResultStaxUnmarshaller();
        return instance;
    }
}
