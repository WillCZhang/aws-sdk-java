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
package com.amazonaws.services.ec2;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.auth.*;

import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.internal.auth.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.client.builder.AdvancedConfig;

import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.waiters.AmazonEC2Waiters;

import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.ec2.model.transform.*;

/**
 * Client for accessing Amazon EC2. All service calls made using this client are blocking, and will not return until the
 * service call completes.
 * <p>
 * <fullname>Amazon Elastic Compute Cloud</fullname>
 * <p>
 * Amazon Elastic Compute Cloud (Amazon EC2) provides secure and resizable computing capacity in the AWS cloud. Using
 * Amazon EC2 eliminates the need to invest in hardware up front, so you can develop and deploy applications faster.
 * </p>
 * <p>
 * To learn more about Amazon EC2, Amazon EBS, and Amazon VPC, see the following resources:
 * </p>
 * <ul>
 * <li>
 * <p>
 * <a href="http://aws.amazon.com/ec2">Amazon EC2 product page</a>
 * </p>
 * </li>
 * <li>
 * <p>
 * <a href="http://aws.amazon.com/documentation/ec2">Amazon EC2 documentation</a>
 * </p>
 * </li>
 * <li>
 * <p>
 * <a href="http://aws.amazon.com/ebs">Amazon EBS product page</a>
 * </p>
 * </li>
 * <li>
 * <p>
 * <a href="http://aws.amazon.com/vpc">Amazon VPC product page</a>
 * </p>
 * </li>
 * <li>
 * <p>
 * <a href="http://aws.amazon.com/documentation/vpc">Amazon VPC documentation</a>
 * </p>
 * </li>
 * </ul>
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AmazonEC2Client extends AmazonWebServiceClient implements AmazonEC2 {

    /** Provider for AWS credentials. */
    private final AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AmazonEC2.class);

    /** Default signing name for the service. */
    private static final String DEFAULT_SIGNING_NAME = "ec2";

    private volatile AmazonEC2Waiters waiters;

    /** Client configuration factory providing ClientConfigurations tailored to this client */
    protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();

    private final AdvancedConfig advancedConfig;

    /**
     * List of exception unmarshallers for all modeled exceptions
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on Amazon EC2. A credentials provider chain will be used that
     * searches for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2 metadata service</li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     * @deprecated use {@link AmazonEC2ClientBuilder#defaultClient()}
     */
    @Deprecated
    public AmazonEC2Client() {
        this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2. A credentials provider chain will be used that
     * searches for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2 metadata service</li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientConfiguration
     *        The client configuration options controlling how this client connects to Amazon EC2 (ex: proxy settings,
     *        retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     * @deprecated use {@link AmazonEC2ClientBuilder#withClientConfiguration(ClientConfiguration)}
     */
    @Deprecated
    public AmazonEC2Client(ClientConfiguration clientConfiguration) {
        this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when authenticating with AWS services.
     * @deprecated use {@link AmazonEC2ClientBuilder#withCredentials(AWSCredentialsProvider)} for example:
     *             {@code AmazonEC2ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();}
     */
    @Deprecated
    public AmazonEC2Client(AWSCredentials awsCredentials) {
        this(awsCredentials, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified AWS account credentials and
     * client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when authenticating with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client connects to Amazon EC2 (ex: proxy settings,
     *        retry counts, etc.).
     * @deprecated use {@link AmazonEC2ClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AmazonEC2ClientBuilder#withClientConfiguration(ClientConfiguration)}
     */
    @Deprecated
    public AmazonEC2Client(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        this.advancedConfig = AdvancedConfig.EMPTY;
        init();
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified AWS account credentials
     * provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @deprecated use {@link AmazonEC2ClientBuilder#withCredentials(AWSCredentialsProvider)}
     */
    @Deprecated
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client connects to Amazon EC2 (ex: proxy settings,
     *        retry counts, etc.).
     * @deprecated use {@link AmazonEC2ClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AmazonEC2ClientBuilder#withClientConfiguration(ClientConfiguration)}
     */
    @Deprecated
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to authenticate requests with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client connects to Amazon EC2 (ex: proxy settings,
     *        retry counts, etc.).
     * @param requestMetricCollector
     *        optional request metric collector
     * @deprecated use {@link AmazonEC2ClientBuilder#withCredentials(AWSCredentialsProvider)} and
     *             {@link AmazonEC2ClientBuilder#withClientConfiguration(ClientConfiguration)} and
     *             {@link AmazonEC2ClientBuilder#withMetricsCollector(RequestMetricCollector)}
     */
    @Deprecated
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        this.advancedConfig = AdvancedConfig.EMPTY;
        init();
    }

    public static AmazonEC2ClientBuilder builder() {
        return AmazonEC2ClientBuilder.standard();
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AmazonEC2Client(AwsSyncClientParams clientParams) {
        this(clientParams, false);
    }

    /**
     * Constructs a new client to invoke service methods on Amazon EC2 using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AmazonEC2Client(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled) {
        super(clientParams);
        this.awsCredentialsProvider = clientParams.getCredentialsProvider();
        this.advancedConfig = clientParams.getAdvancedConfig();
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new LegacyErrorUnmarshaller(com.amazonaws.services.ec2.model.AmazonEC2Exception.class));

        setServiceNameIntern(DEFAULT_SIGNING_NAME);
        setEndpointPrefix(ENDPOINT_PREFIX);
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("https://ec2.us-east-1.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazonaws/services/ec2/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazonaws/services/ec2/request.handler2s"));
        requestHandler2s.addAll(chainFactory.getGlobalHandlers());
    }

    /**
     * <p>
     * Accepts the Convertible Reserved Instance exchange quote described in the
     * <a>GetReservedInstancesExchangeQuote</a> call.
     * </p>
     * 
     * @param acceptReservedInstancesExchangeQuoteRequest
     *        Contains the parameters for accepting the quote.
     * @return Result of the AcceptReservedInstancesExchangeQuote operation returned by the service.
     * @sample AmazonEC2.AcceptReservedInstancesExchangeQuote
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AcceptReservedInstancesExchangeQuote"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AcceptReservedInstancesExchangeQuoteResult acceptReservedInstancesExchangeQuote(AcceptReservedInstancesExchangeQuoteRequest request) {
        request = beforeClientExecution(request);
        return executeAcceptReservedInstancesExchangeQuote(request);
    }

    @SdkInternalApi
    final AcceptReservedInstancesExchangeQuoteResult executeAcceptReservedInstancesExchangeQuote(
            AcceptReservedInstancesExchangeQuoteRequest acceptReservedInstancesExchangeQuoteRequest) {

        ExecutionContext executionContext = createExecutionContext(acceptReservedInstancesExchangeQuoteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AcceptReservedInstancesExchangeQuoteRequest> request = null;
        Response<AcceptReservedInstancesExchangeQuoteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AcceptReservedInstancesExchangeQuoteRequestMarshaller().marshall(super
                        .beforeMarshalling(acceptReservedInstancesExchangeQuoteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AcceptReservedInstancesExchangeQuote");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AcceptReservedInstancesExchangeQuoteResult> responseHandler = new StaxResponseHandler<AcceptReservedInstancesExchangeQuoteResult>(
                    new AcceptReservedInstancesExchangeQuoteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Accepts a request to attach a VPC to a transit gateway.
     * </p>
     * <p>
     * The VPC attachment must be in the <code>pendingAcceptance</code> state. Use
     * <a>DescribeTransitGatewayVpcAttachments</a> to view your pending VPC attachment requests. Use
     * <a>RejectTransitGatewayVpcAttachment</a> to reject a VPC attachment request.
     * </p>
     * 
     * @param acceptTransitGatewayVpcAttachmentRequest
     * @return Result of the AcceptTransitGatewayVpcAttachment operation returned by the service.
     * @sample AmazonEC2.AcceptTransitGatewayVpcAttachment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AcceptTransitGatewayVpcAttachment"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AcceptTransitGatewayVpcAttachmentResult acceptTransitGatewayVpcAttachment(AcceptTransitGatewayVpcAttachmentRequest request) {
        request = beforeClientExecution(request);
        return executeAcceptTransitGatewayVpcAttachment(request);
    }

    @SdkInternalApi
    final AcceptTransitGatewayVpcAttachmentResult executeAcceptTransitGatewayVpcAttachment(
            AcceptTransitGatewayVpcAttachmentRequest acceptTransitGatewayVpcAttachmentRequest) {

        ExecutionContext executionContext = createExecutionContext(acceptTransitGatewayVpcAttachmentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AcceptTransitGatewayVpcAttachmentRequest> request = null;
        Response<AcceptTransitGatewayVpcAttachmentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AcceptTransitGatewayVpcAttachmentRequestMarshaller().marshall(super.beforeMarshalling(acceptTransitGatewayVpcAttachmentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AcceptTransitGatewayVpcAttachment");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AcceptTransitGatewayVpcAttachmentResult> responseHandler = new StaxResponseHandler<AcceptTransitGatewayVpcAttachmentResult>(
                    new AcceptTransitGatewayVpcAttachmentResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Accepts one or more interface VPC endpoint connection requests to your VPC endpoint service.
     * </p>
     * 
     * @param acceptVpcEndpointConnectionsRequest
     * @return Result of the AcceptVpcEndpointConnections operation returned by the service.
     * @sample AmazonEC2.AcceptVpcEndpointConnections
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AcceptVpcEndpointConnections"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AcceptVpcEndpointConnectionsResult acceptVpcEndpointConnections(AcceptVpcEndpointConnectionsRequest request) {
        request = beforeClientExecution(request);
        return executeAcceptVpcEndpointConnections(request);
    }

    @SdkInternalApi
    final AcceptVpcEndpointConnectionsResult executeAcceptVpcEndpointConnections(AcceptVpcEndpointConnectionsRequest acceptVpcEndpointConnectionsRequest) {

        ExecutionContext executionContext = createExecutionContext(acceptVpcEndpointConnectionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AcceptVpcEndpointConnectionsRequest> request = null;
        Response<AcceptVpcEndpointConnectionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AcceptVpcEndpointConnectionsRequestMarshaller().marshall(super.beforeMarshalling(acceptVpcEndpointConnectionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AcceptVpcEndpointConnections");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AcceptVpcEndpointConnectionsResult> responseHandler = new StaxResponseHandler<AcceptVpcEndpointConnectionsResult>(
                    new AcceptVpcEndpointConnectionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Accept a VPC peering connection request. To accept a request, the VPC peering connection must be in the
     * <code>pending-acceptance</code> state, and you must be the owner of the peer VPC. Use
     * <a>DescribeVpcPeeringConnections</a> to view your outstanding VPC peering connection requests.
     * </p>
     * <p>
     * For an inter-region VPC peering connection request, you must accept the VPC peering connection in the region of
     * the accepter VPC.
     * </p>
     * 
     * @param acceptVpcPeeringConnectionRequest
     * @return Result of the AcceptVpcPeeringConnection operation returned by the service.
     * @sample AmazonEC2.AcceptVpcPeeringConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AcceptVpcPeeringConnection" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public AcceptVpcPeeringConnectionResult acceptVpcPeeringConnection(AcceptVpcPeeringConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeAcceptVpcPeeringConnection(request);
    }

    @SdkInternalApi
    final AcceptVpcPeeringConnectionResult executeAcceptVpcPeeringConnection(AcceptVpcPeeringConnectionRequest acceptVpcPeeringConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(acceptVpcPeeringConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AcceptVpcPeeringConnectionRequest> request = null;
        Response<AcceptVpcPeeringConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AcceptVpcPeeringConnectionRequestMarshaller().marshall(super.beforeMarshalling(acceptVpcPeeringConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AcceptVpcPeeringConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AcceptVpcPeeringConnectionResult> responseHandler = new StaxResponseHandler<AcceptVpcPeeringConnectionResult>(
                    new AcceptVpcPeeringConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public AcceptVpcPeeringConnectionResult acceptVpcPeeringConnection() {
        return acceptVpcPeeringConnection(new AcceptVpcPeeringConnectionRequest());
    }

    /**
     * <p>
     * Advertises an IPv4 address range that is provisioned for use with your AWS resources through bring your own IP
     * addresses (BYOIP).
     * </p>
     * <p>
     * You can perform this operation at most once every 10 seconds, even if you specify different address ranges each
     * time.
     * </p>
     * <p>
     * We recommend that you stop advertising the BYOIP CIDR from other locations when you advertise it from AWS. To
     * minimize down time, you can configure your AWS resources to use an address from a BYOIP CIDR before it is
     * advertised, and then simultaneously stop advertising it from the current location and start advertising it
     * through AWS.
     * </p>
     * <p>
     * It can take a few minutes before traffic to the specified addresses starts routing to AWS because of BGP
     * propagation delays.
     * </p>
     * <p>
     * To stop advertising the BYOIP CIDR, use <a>WithdrawByoipCidr</a>.
     * </p>
     * 
     * @param advertiseByoipCidrRequest
     * @return Result of the AdvertiseByoipCidr operation returned by the service.
     * @sample AmazonEC2.AdvertiseByoipCidr
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AdvertiseByoipCidr" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AdvertiseByoipCidrResult advertiseByoipCidr(AdvertiseByoipCidrRequest request) {
        request = beforeClientExecution(request);
        return executeAdvertiseByoipCidr(request);
    }

    @SdkInternalApi
    final AdvertiseByoipCidrResult executeAdvertiseByoipCidr(AdvertiseByoipCidrRequest advertiseByoipCidrRequest) {

        ExecutionContext executionContext = createExecutionContext(advertiseByoipCidrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AdvertiseByoipCidrRequest> request = null;
        Response<AdvertiseByoipCidrResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AdvertiseByoipCidrRequestMarshaller().marshall(super.beforeMarshalling(advertiseByoipCidrRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AdvertiseByoipCidr");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AdvertiseByoipCidrResult> responseHandler = new StaxResponseHandler<AdvertiseByoipCidrResult>(
                    new AdvertiseByoipCidrResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Allocates an Elastic IP address to your AWS account. After you allocate the Elastic IP address you can associate
     * it with an instance or network interface. After you release an Elastic IP address, it is released to the IP
     * address pool and can be allocated to a different AWS account.
     * </p>
     * <p>
     * You can allocate an Elastic IP address from an address pool owned by AWS or from an address pool created from a
     * public IPv4 address range that you have brought to AWS for use with your AWS resources using bring your own IP
     * addresses (BYOIP). For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-byoip.html">Bring Your Own IP Addresses (BYOIP)</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * [EC2-VPC] If you release an Elastic IP address, you might be able to recover it. You cannot recover an Elastic IP
     * address that you released after it is allocated to another AWS account. You cannot recover an Elastic IP address
     * for EC2-Classic. To attempt to recover an Elastic IP address that you released, specify it in this operation.
     * </p>
     * <p>
     * An Elastic IP address is for use either in the EC2-Classic platform or in a VPC. By default, you can allocate 5
     * Elastic IP addresses for EC2-Classic per region and 5 Elastic IP addresses for EC2-VPC per region.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html">Elastic IP Addresses</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param allocateAddressRequest
     * @return Result of the AllocateAddress operation returned by the service.
     * @sample AmazonEC2.AllocateAddress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AllocateAddress" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AllocateAddressResult allocateAddress(AllocateAddressRequest request) {
        request = beforeClientExecution(request);
        return executeAllocateAddress(request);
    }

    @SdkInternalApi
    final AllocateAddressResult executeAllocateAddress(AllocateAddressRequest allocateAddressRequest) {

        ExecutionContext executionContext = createExecutionContext(allocateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AllocateAddressRequest> request = null;
        Response<AllocateAddressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AllocateAddressRequestMarshaller().marshall(super.beforeMarshalling(allocateAddressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AllocateAddress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AllocateAddressResult> responseHandler = new StaxResponseHandler<AllocateAddressResult>(
                    new AllocateAddressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public AllocateAddressResult allocateAddress() {
        return allocateAddress(new AllocateAddressRequest());
    }

    /**
     * <p>
     * Allocates a Dedicated Host to your account. At a minimum, specify the instance size type, Availability Zone, and
     * quantity of hosts to allocate.
     * </p>
     * 
     * @param allocateHostsRequest
     * @return Result of the AllocateHosts operation returned by the service.
     * @sample AmazonEC2.AllocateHosts
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AllocateHosts" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AllocateHostsResult allocateHosts(AllocateHostsRequest request) {
        request = beforeClientExecution(request);
        return executeAllocateHosts(request);
    }

    @SdkInternalApi
    final AllocateHostsResult executeAllocateHosts(AllocateHostsRequest allocateHostsRequest) {

        ExecutionContext executionContext = createExecutionContext(allocateHostsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AllocateHostsRequest> request = null;
        Response<AllocateHostsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AllocateHostsRequestMarshaller().marshall(super.beforeMarshalling(allocateHostsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AllocateHosts");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AllocateHostsResult> responseHandler = new StaxResponseHandler<AllocateHostsResult>(new AllocateHostsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Assigns one or more IPv6 addresses to the specified network interface. You can specify one or more specific IPv6
     * addresses, or you can specify the number of IPv6 addresses to be automatically assigned from within the subnet's
     * IPv6 CIDR block range. You can assign as many IPv6 addresses to a network interface as you can assign private
     * IPv4 addresses, and the limit varies per instance type. For information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html#AvailableIpPerENI">IP Addresses Per
     * Network Interface Per Instance Type</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param assignIpv6AddressesRequest
     * @return Result of the AssignIpv6Addresses operation returned by the service.
     * @sample AmazonEC2.AssignIpv6Addresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssignIpv6Addresses" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AssignIpv6AddressesResult assignIpv6Addresses(AssignIpv6AddressesRequest request) {
        request = beforeClientExecution(request);
        return executeAssignIpv6Addresses(request);
    }

    @SdkInternalApi
    final AssignIpv6AddressesResult executeAssignIpv6Addresses(AssignIpv6AddressesRequest assignIpv6AddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(assignIpv6AddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssignIpv6AddressesRequest> request = null;
        Response<AssignIpv6AddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssignIpv6AddressesRequestMarshaller().marshall(super.beforeMarshalling(assignIpv6AddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssignIpv6Addresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssignIpv6AddressesResult> responseHandler = new StaxResponseHandler<AssignIpv6AddressesResult>(
                    new AssignIpv6AddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Assigns one or more secondary private IP addresses to the specified network interface.
     * </p>
     * <p>
     * You can specify one or more specific secondary IP addresses, or you can specify the number of secondary IP
     * addresses to be automatically assigned within the subnet's CIDR block range. The number of secondary IP addresses
     * that you can assign to an instance varies by instance type. For information about instance types, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-types.html">Instance Types</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>. For more information about Elastic IP addresses, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html">Elastic IP Addresses</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * When you move a secondary private IP address to another network interface, any Elastic IP address that is
     * associated with the IP address is also moved.
     * </p>
     * <p>
     * Remapping an IP address is an asynchronous operation. When you move an IP address from one network interface to
     * another, check <code>network/interfaces/macs/mac/local-ipv4s</code> in the instance metadata to confirm that the
     * remapping is complete.
     * </p>
     * 
     * @param assignPrivateIpAddressesRequest
     *        Contains the parameters for AssignPrivateIpAddresses.
     * @return Result of the AssignPrivateIpAddresses operation returned by the service.
     * @sample AmazonEC2.AssignPrivateIpAddresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssignPrivateIpAddresses" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public AssignPrivateIpAddressesResult assignPrivateIpAddresses(AssignPrivateIpAddressesRequest request) {
        request = beforeClientExecution(request);
        return executeAssignPrivateIpAddresses(request);
    }

    @SdkInternalApi
    final AssignPrivateIpAddressesResult executeAssignPrivateIpAddresses(AssignPrivateIpAddressesRequest assignPrivateIpAddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(assignPrivateIpAddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssignPrivateIpAddressesRequest> request = null;
        Response<AssignPrivateIpAddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssignPrivateIpAddressesRequestMarshaller().marshall(super.beforeMarshalling(assignPrivateIpAddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssignPrivateIpAddresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssignPrivateIpAddressesResult> responseHandler = new StaxResponseHandler<AssignPrivateIpAddressesResult>(
                    new AssignPrivateIpAddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates an Elastic IP address with an instance or a network interface. Before you can use an Elastic IP
     * address, you must allocate it to your account.
     * </p>
     * <p>
     * An Elastic IP address is for use in either the EC2-Classic platform or in a VPC. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html">Elastic IP Addresses</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * [EC2-Classic, VPC in an EC2-VPC-only account] If the Elastic IP address is already associated with a different
     * instance, it is disassociated from that instance and associated with the specified instance. If you associate an
     * Elastic IP address with an instance that has an existing Elastic IP address, the existing address is
     * disassociated from the instance, but remains allocated to your account.
     * </p>
     * <p>
     * [VPC in an EC2-Classic account] If you don't specify a private IP address, the Elastic IP address is associated
     * with the primary IP address. If the Elastic IP address is already associated with a different instance or a
     * network interface, you get an error unless you allow reassociation. You cannot associate an Elastic IP address
     * with an instance or network interface that has an existing Elastic IP address.
     * </p>
     * <important>
     * <p>
     * This is an idempotent operation. If you perform the operation more than once, Amazon EC2 doesn't return an error,
     * and you may be charged for each time the Elastic IP address is remapped to the same instance. For more
     * information, see the <i>Elastic IP Addresses</i> section of <a href="http://aws.amazon.com/ec2/pricing/">Amazon
     * EC2 Pricing</a>.
     * </p>
     * </important>
     * 
     * @param associateAddressRequest
     * @return Result of the AssociateAddress operation returned by the service.
     * @sample AmazonEC2.AssociateAddress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateAddress" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AssociateAddressResult associateAddress(AssociateAddressRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateAddress(request);
    }

    @SdkInternalApi
    final AssociateAddressResult executeAssociateAddress(AssociateAddressRequest associateAddressRequest) {

        ExecutionContext executionContext = createExecutionContext(associateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateAddressRequest> request = null;
        Response<AssociateAddressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateAddressRequestMarshaller().marshall(super.beforeMarshalling(associateAddressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateAddress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateAddressResult> responseHandler = new StaxResponseHandler<AssociateAddressResult>(
                    new AssociateAddressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates a set of DHCP options (that you've previously created) with the specified VPC, or associates no DHCP
     * options with the VPC.
     * </p>
     * <p>
     * After you associate the options with the VPC, any existing instances and all new instances that you launch in
     * that VPC use the options. You don't need to restart or relaunch the instances. They automatically pick up the
     * changes within a few hours, depending on how frequently the instance renews its DHCP lease. You can explicitly
     * renew the lease using the operating system on the instance.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_DHCP_Options.html">DHCP Options Sets</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param associateDhcpOptionsRequest
     * @return Result of the AssociateDhcpOptions operation returned by the service.
     * @sample AmazonEC2.AssociateDhcpOptions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateDhcpOptions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AssociateDhcpOptionsResult associateDhcpOptions(AssociateDhcpOptionsRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateDhcpOptions(request);
    }

    @SdkInternalApi
    final AssociateDhcpOptionsResult executeAssociateDhcpOptions(AssociateDhcpOptionsRequest associateDhcpOptionsRequest) {

        ExecutionContext executionContext = createExecutionContext(associateDhcpOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateDhcpOptionsRequest> request = null;
        Response<AssociateDhcpOptionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateDhcpOptionsRequestMarshaller().marshall(super.beforeMarshalling(associateDhcpOptionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateDhcpOptions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateDhcpOptionsResult> responseHandler = new StaxResponseHandler<AssociateDhcpOptionsResult>(
                    new AssociateDhcpOptionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates an IAM instance profile with a running or stopped instance. You cannot associate more than one IAM
     * instance profile with an instance.
     * </p>
     * 
     * @param associateIamInstanceProfileRequest
     * @return Result of the AssociateIamInstanceProfile operation returned by the service.
     * @sample AmazonEC2.AssociateIamInstanceProfile
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateIamInstanceProfile"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AssociateIamInstanceProfileResult associateIamInstanceProfile(AssociateIamInstanceProfileRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateIamInstanceProfile(request);
    }

    @SdkInternalApi
    final AssociateIamInstanceProfileResult executeAssociateIamInstanceProfile(AssociateIamInstanceProfileRequest associateIamInstanceProfileRequest) {

        ExecutionContext executionContext = createExecutionContext(associateIamInstanceProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateIamInstanceProfileRequest> request = null;
        Response<AssociateIamInstanceProfileResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateIamInstanceProfileRequestMarshaller().marshall(super.beforeMarshalling(associateIamInstanceProfileRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateIamInstanceProfile");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateIamInstanceProfileResult> responseHandler = new StaxResponseHandler<AssociateIamInstanceProfileResult>(
                    new AssociateIamInstanceProfileResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates a subnet with a route table. The subnet and route table must be in the same VPC. This association
     * causes traffic originating from the subnet to be routed according to the routes in the route table. The action
     * returns an association ID, which you need in order to disassociate the route table from the subnet later. A route
     * table can be associated with multiple subnets.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param associateRouteTableRequest
     * @return Result of the AssociateRouteTable operation returned by the service.
     * @sample AmazonEC2.AssociateRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateRouteTable" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AssociateRouteTableResult associateRouteTable(AssociateRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateRouteTable(request);
    }

    @SdkInternalApi
    final AssociateRouteTableResult executeAssociateRouteTable(AssociateRouteTableRequest associateRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(associateRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateRouteTableRequest> request = null;
        Response<AssociateRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateRouteTableRequestMarshaller().marshall(super.beforeMarshalling(associateRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateRouteTableResult> responseHandler = new StaxResponseHandler<AssociateRouteTableResult>(
                    new AssociateRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates a CIDR block with your subnet. You can only associate a single IPv6 CIDR block with your subnet. An
     * IPv6 CIDR block must have a prefix length of /64.
     * </p>
     * 
     * @param associateSubnetCidrBlockRequest
     * @return Result of the AssociateSubnetCidrBlock operation returned by the service.
     * @sample AmazonEC2.AssociateSubnetCidrBlock
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateSubnetCidrBlock" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public AssociateSubnetCidrBlockResult associateSubnetCidrBlock(AssociateSubnetCidrBlockRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateSubnetCidrBlock(request);
    }

    @SdkInternalApi
    final AssociateSubnetCidrBlockResult executeAssociateSubnetCidrBlock(AssociateSubnetCidrBlockRequest associateSubnetCidrBlockRequest) {

        ExecutionContext executionContext = createExecutionContext(associateSubnetCidrBlockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateSubnetCidrBlockRequest> request = null;
        Response<AssociateSubnetCidrBlockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateSubnetCidrBlockRequestMarshaller().marshall(super.beforeMarshalling(associateSubnetCidrBlockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateSubnetCidrBlock");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateSubnetCidrBlockResult> responseHandler = new StaxResponseHandler<AssociateSubnetCidrBlockResult>(
                    new AssociateSubnetCidrBlockResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates the specified attachment with the specified transit gateway route table. You can associate only one
     * route table with an attachment.
     * </p>
     * 
     * @param associateTransitGatewayRouteTableRequest
     * @return Result of the AssociateTransitGatewayRouteTable operation returned by the service.
     * @sample AmazonEC2.AssociateTransitGatewayRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateTransitGatewayRouteTable"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AssociateTransitGatewayRouteTableResult associateTransitGatewayRouteTable(AssociateTransitGatewayRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateTransitGatewayRouteTable(request);
    }

    @SdkInternalApi
    final AssociateTransitGatewayRouteTableResult executeAssociateTransitGatewayRouteTable(
            AssociateTransitGatewayRouteTableRequest associateTransitGatewayRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(associateTransitGatewayRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateTransitGatewayRouteTableRequest> request = null;
        Response<AssociateTransitGatewayRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateTransitGatewayRouteTableRequestMarshaller().marshall(super.beforeMarshalling(associateTransitGatewayRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateTransitGatewayRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateTransitGatewayRouteTableResult> responseHandler = new StaxResponseHandler<AssociateTransitGatewayRouteTableResult>(
                    new AssociateTransitGatewayRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Associates a CIDR block with your VPC. You can associate a secondary IPv4 CIDR block, or you can associate an
     * Amazon-provided IPv6 CIDR block. The IPv6 CIDR block size is fixed at /56.
     * </p>
     * <p>
     * For more information about associating CIDR blocks with your VPC and applicable restrictions, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Subnets.html#VPC_Sizing">VPC and Subnet
     * Sizing</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param associateVpcCidrBlockRequest
     * @return Result of the AssociateVpcCidrBlock operation returned by the service.
     * @sample AmazonEC2.AssociateVpcCidrBlock
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AssociateVpcCidrBlock" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AssociateVpcCidrBlockResult associateVpcCidrBlock(AssociateVpcCidrBlockRequest request) {
        request = beforeClientExecution(request);
        return executeAssociateVpcCidrBlock(request);
    }

    @SdkInternalApi
    final AssociateVpcCidrBlockResult executeAssociateVpcCidrBlock(AssociateVpcCidrBlockRequest associateVpcCidrBlockRequest) {

        ExecutionContext executionContext = createExecutionContext(associateVpcCidrBlockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AssociateVpcCidrBlockRequest> request = null;
        Response<AssociateVpcCidrBlockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AssociateVpcCidrBlockRequestMarshaller().marshall(super.beforeMarshalling(associateVpcCidrBlockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssociateVpcCidrBlock");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AssociateVpcCidrBlockResult> responseHandler = new StaxResponseHandler<AssociateVpcCidrBlockResult>(
                    new AssociateVpcCidrBlockResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Links an EC2-Classic instance to a ClassicLink-enabled VPC through one or more of the VPC's security groups. You
     * cannot link an EC2-Classic instance to more than one VPC at a time. You can only link an instance that's in the
     * <code>running</code> state. An instance is automatically unlinked from a VPC when it's stopped - you can link it
     * to the VPC again when you restart it.
     * </p>
     * <p>
     * After you've linked an instance, you cannot change the VPC security groups that are associated with it. To change
     * the security groups, you must first unlink the instance, and then link it again.
     * </p>
     * <p>
     * Linking your instance to a VPC is sometimes referred to as <i>attaching</i> your instance.
     * </p>
     * 
     * @param attachClassicLinkVpcRequest
     * @return Result of the AttachClassicLinkVpc operation returned by the service.
     * @sample AmazonEC2.AttachClassicLinkVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AttachClassicLinkVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AttachClassicLinkVpcResult attachClassicLinkVpc(AttachClassicLinkVpcRequest request) {
        request = beforeClientExecution(request);
        return executeAttachClassicLinkVpc(request);
    }

    @SdkInternalApi
    final AttachClassicLinkVpcResult executeAttachClassicLinkVpc(AttachClassicLinkVpcRequest attachClassicLinkVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(attachClassicLinkVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachClassicLinkVpcRequest> request = null;
        Response<AttachClassicLinkVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachClassicLinkVpcRequestMarshaller().marshall(super.beforeMarshalling(attachClassicLinkVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachClassicLinkVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AttachClassicLinkVpcResult> responseHandler = new StaxResponseHandler<AttachClassicLinkVpcResult>(
                    new AttachClassicLinkVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Attaches an internet gateway to a VPC, enabling connectivity between the internet and the VPC. For more
     * information about your VPC and internet gateway, see the <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/">Amazon Virtual Private Cloud User Guide</a>.
     * </p>
     * 
     * @param attachInternetGatewayRequest
     * @return Result of the AttachInternetGateway operation returned by the service.
     * @sample AmazonEC2.AttachInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AttachInternetGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AttachInternetGatewayResult attachInternetGateway(AttachInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeAttachInternetGateway(request);
    }

    @SdkInternalApi
    final AttachInternetGatewayResult executeAttachInternetGateway(AttachInternetGatewayRequest attachInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(attachInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachInternetGatewayRequest> request = null;
        Response<AttachInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(attachInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AttachInternetGatewayResult> responseHandler = new StaxResponseHandler<AttachInternetGatewayResult>(
                    new AttachInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Attaches a network interface to an instance.
     * </p>
     * 
     * @param attachNetworkInterfaceRequest
     *        Contains the parameters for AttachNetworkInterface.
     * @return Result of the AttachNetworkInterface operation returned by the service.
     * @sample AmazonEC2.AttachNetworkInterface
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AttachNetworkInterface" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AttachNetworkInterfaceResult attachNetworkInterface(AttachNetworkInterfaceRequest request) {
        request = beforeClientExecution(request);
        return executeAttachNetworkInterface(request);
    }

    @SdkInternalApi
    final AttachNetworkInterfaceResult executeAttachNetworkInterface(AttachNetworkInterfaceRequest attachNetworkInterfaceRequest) {

        ExecutionContext executionContext = createExecutionContext(attachNetworkInterfaceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachNetworkInterfaceRequest> request = null;
        Response<AttachNetworkInterfaceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachNetworkInterfaceRequestMarshaller().marshall(super.beforeMarshalling(attachNetworkInterfaceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachNetworkInterface");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AttachNetworkInterfaceResult> responseHandler = new StaxResponseHandler<AttachNetworkInterfaceResult>(
                    new AttachNetworkInterfaceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Attaches an EBS volume to a running or stopped instance and exposes it to the instance with the specified device
     * name.
     * </p>
     * <p>
     * Encrypted EBS volumes may only be attached to instances that support Amazon EBS encryption. For more information,
     * see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html">Amazon EBS Encryption</a> in
     * the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * For a list of supported device names, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-attaching-volume.html">Attaching an EBS Volume to an
     * Instance</a>. Any device names that aren't reserved for instance store volumes can be used for EBS volumes. For
     * more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/InstanceStorage.html">Amazon
     * EC2 Instance Store</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * If a volume has an AWS Marketplace product code:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The volume can be attached only to a stopped instance.
     * </p>
     * </li>
     * <li>
     * <p>
     * AWS Marketplace product codes are copied from the volume to the instance.
     * </p>
     * </li>
     * <li>
     * <p>
     * You must be subscribed to the product.
     * </p>
     * </li>
     * <li>
     * <p>
     * The instance type and operating system of the instance must support the product. For example, you can't detach a
     * volume from a Windows instance and attach it to a Linux instance.
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information about EBS volumes, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-attaching-volume.html">Attaching Amazon EBS
     * Volumes</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param attachVolumeRequest
     *        Contains the parameters for AttachVolume.
     * @return Result of the AttachVolume operation returned by the service.
     * @sample AmazonEC2.AttachVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AttachVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AttachVolumeResult attachVolume(AttachVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeAttachVolume(request);
    }

    @SdkInternalApi
    final AttachVolumeResult executeAttachVolume(AttachVolumeRequest attachVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(attachVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachVolumeRequest> request = null;
        Response<AttachVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachVolumeRequestMarshaller().marshall(super.beforeMarshalling(attachVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AttachVolumeResult> responseHandler = new StaxResponseHandler<AttachVolumeResult>(new AttachVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Attaches a virtual private gateway to a VPC. You can attach one virtual private gateway to one VPC at a time.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS
     * Managed VPN Connections</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param attachVpnGatewayRequest
     *        Contains the parameters for AttachVpnGateway.
     * @return Result of the AttachVpnGateway operation returned by the service.
     * @sample AmazonEC2.AttachVpnGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AttachVpnGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public AttachVpnGatewayResult attachVpnGateway(AttachVpnGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeAttachVpnGateway(request);
    }

    @SdkInternalApi
    final AttachVpnGatewayResult executeAttachVpnGateway(AttachVpnGatewayRequest attachVpnGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(attachVpnGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AttachVpnGatewayRequest> request = null;
        Response<AttachVpnGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AttachVpnGatewayRequestMarshaller().marshall(super.beforeMarshalling(attachVpnGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachVpnGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AttachVpnGatewayResult> responseHandler = new StaxResponseHandler<AttachVpnGatewayResult>(
                    new AttachVpnGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * [EC2-VPC only] Adds one or more egress rules to a security group for use with a VPC. Specifically, this action
     * permits instances to send traffic to one or more destination IPv4 or IPv6 CIDR address ranges, or to one or more
     * destination security groups for the same VPC. This action doesn't apply to security groups for use in
     * EC2-Classic. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html">Security Groups for Your
     * VPC</a> in the <i>Amazon Virtual Private Cloud User Guide</i>. For more information about security group limits,
     * see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Appendix_Limits.html">Amazon VPC
     * Limits</a>.
     * </p>
     * <p>
     * Each rule consists of the protocol (for example, TCP), plus either a CIDR range or a source group. For the TCP
     * and UDP protocols, you must also specify the destination port or port range. For the ICMP protocol, you must also
     * specify the ICMP type and code. You can use -1 for the type or code to mean all types or all codes. You can
     * optionally specify a description for the rule.
     * </p>
     * <p>
     * Rule changes are propagated to affected instances as quickly as possible. However, a small delay might occur.
     * </p>
     * 
     * @param authorizeSecurityGroupEgressRequest
     * @return Result of the AuthorizeSecurityGroupEgress operation returned by the service.
     * @sample AmazonEC2.AuthorizeSecurityGroupEgress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AuthorizeSecurityGroupEgress"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AuthorizeSecurityGroupEgressResult authorizeSecurityGroupEgress(AuthorizeSecurityGroupEgressRequest request) {
        request = beforeClientExecution(request);
        return executeAuthorizeSecurityGroupEgress(request);
    }

    @SdkInternalApi
    final AuthorizeSecurityGroupEgressResult executeAuthorizeSecurityGroupEgress(AuthorizeSecurityGroupEgressRequest authorizeSecurityGroupEgressRequest) {

        ExecutionContext executionContext = createExecutionContext(authorizeSecurityGroupEgressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AuthorizeSecurityGroupEgressRequest> request = null;
        Response<AuthorizeSecurityGroupEgressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AuthorizeSecurityGroupEgressRequestMarshaller().marshall(super.beforeMarshalling(authorizeSecurityGroupEgressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AuthorizeSecurityGroupEgress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AuthorizeSecurityGroupEgressResult> responseHandler = new StaxResponseHandler<AuthorizeSecurityGroupEgressResult>(
                    new AuthorizeSecurityGroupEgressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Adds one or more ingress rules to a security group.
     * </p>
     * <p>
     * Rule changes are propagated to instances within the security group as quickly as possible. However, a small delay
     * might occur.
     * </p>
     * <p>
     * [EC2-Classic] This action gives one or more IPv4 CIDR address ranges permission to access a security group in
     * your account, or gives one or more security groups (called the <i>source groups</i>) permission to access a
     * security group for your account. A source group can be for your own AWS account, or another. You can have up to
     * 100 rules per group.
     * </p>
     * <p>
     * [EC2-VPC] This action gives one or more IPv4 or IPv6 CIDR address ranges permission to access a security group in
     * your VPC, or gives one or more other security groups (called the <i>source groups</i>) permission to access a
     * security group for your VPC. The security groups must all be for the same VPC or a peer VPC in a VPC peering
     * connection. For more information about VPC security group limits, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Appendix_Limits.html">Amazon VPC Limits</a>.
     * </p>
     * <p>
     * You can optionally specify a description for the security group rule.
     * </p>
     * 
     * @param authorizeSecurityGroupIngressRequest
     * @return Result of the AuthorizeSecurityGroupIngress operation returned by the service.
     * @sample AmazonEC2.AuthorizeSecurityGroupIngress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/AuthorizeSecurityGroupIngress"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public AuthorizeSecurityGroupIngressResult authorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest request) {
        request = beforeClientExecution(request);
        return executeAuthorizeSecurityGroupIngress(request);
    }

    @SdkInternalApi
    final AuthorizeSecurityGroupIngressResult executeAuthorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) {

        ExecutionContext executionContext = createExecutionContext(authorizeSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AuthorizeSecurityGroupIngressRequest> request = null;
        Response<AuthorizeSecurityGroupIngressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AuthorizeSecurityGroupIngressRequestMarshaller().marshall(super.beforeMarshalling(authorizeSecurityGroupIngressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AuthorizeSecurityGroupIngress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<AuthorizeSecurityGroupIngressResult> responseHandler = new StaxResponseHandler<AuthorizeSecurityGroupIngressResult>(
                    new AuthorizeSecurityGroupIngressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Bundles an Amazon instance store-backed Windows instance.
     * </p>
     * <p>
     * During bundling, only the root device volume (C:\) is bundled. Data on other instance store volumes is not
     * preserved.
     * </p>
     * <note>
     * <p>
     * This action is not applicable for Linux/Unix instances or Windows instances that are backed by Amazon EBS.
     * </p>
     * </note>
     * 
     * @param bundleInstanceRequest
     *        Contains the parameters for BundleInstance.
     * @return Result of the BundleInstance operation returned by the service.
     * @sample AmazonEC2.BundleInstance
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/BundleInstance" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public BundleInstanceResult bundleInstance(BundleInstanceRequest request) {
        request = beforeClientExecution(request);
        return executeBundleInstance(request);
    }

    @SdkInternalApi
    final BundleInstanceResult executeBundleInstance(BundleInstanceRequest bundleInstanceRequest) {

        ExecutionContext executionContext = createExecutionContext(bundleInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<BundleInstanceRequest> request = null;
        Response<BundleInstanceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new BundleInstanceRequestMarshaller().marshall(super.beforeMarshalling(bundleInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "BundleInstance");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<BundleInstanceResult> responseHandler = new StaxResponseHandler<BundleInstanceResult>(
                    new BundleInstanceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels a bundling operation for an instance store-backed Windows instance.
     * </p>
     * 
     * @param cancelBundleTaskRequest
     *        Contains the parameters for CancelBundleTask.
     * @return Result of the CancelBundleTask operation returned by the service.
     * @sample AmazonEC2.CancelBundleTask
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelBundleTask" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CancelBundleTaskResult cancelBundleTask(CancelBundleTaskRequest request) {
        request = beforeClientExecution(request);
        return executeCancelBundleTask(request);
    }

    @SdkInternalApi
    final CancelBundleTaskResult executeCancelBundleTask(CancelBundleTaskRequest cancelBundleTaskRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelBundleTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelBundleTaskRequest> request = null;
        Response<CancelBundleTaskResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelBundleTaskRequestMarshaller().marshall(super.beforeMarshalling(cancelBundleTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelBundleTask");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelBundleTaskResult> responseHandler = new StaxResponseHandler<CancelBundleTaskResult>(
                    new CancelBundleTaskResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels the specified Capacity Reservation, releases the reserved capacity, and changes the Capacity
     * Reservation's state to <code>cancelled</code>.
     * </p>
     * <p>
     * Instances running in the reserved capacity continue running until you stop them. Stopped instances that target
     * the Capacity Reservation can no longer launch. Modify these instances to either target a different Capacity
     * Reservation, launch On-Demand Instance capacity, or run in any open Capacity Reservation that has matching
     * attributes and sufficient capacity.
     * </p>
     * 
     * @param cancelCapacityReservationRequest
     * @return Result of the CancelCapacityReservation operation returned by the service.
     * @sample AmazonEC2.CancelCapacityReservation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelCapacityReservation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CancelCapacityReservationResult cancelCapacityReservation(CancelCapacityReservationRequest request) {
        request = beforeClientExecution(request);
        return executeCancelCapacityReservation(request);
    }

    @SdkInternalApi
    final CancelCapacityReservationResult executeCancelCapacityReservation(CancelCapacityReservationRequest cancelCapacityReservationRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelCapacityReservationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelCapacityReservationRequest> request = null;
        Response<CancelCapacityReservationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelCapacityReservationRequestMarshaller().marshall(super.beforeMarshalling(cancelCapacityReservationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelCapacityReservation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelCapacityReservationResult> responseHandler = new StaxResponseHandler<CancelCapacityReservationResult>(
                    new CancelCapacityReservationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels an active conversion task. The task can be the import of an instance or volume. The action removes all
     * artifacts of the conversion, including a partially uploaded volume or instance. If the conversion is complete or
     * is in the process of transferring the final disk image, the command fails and returns an exception.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/CommandLineReference/ec2-cli-vmimport-export.html">Importing a
     * Virtual Machine Using the Amazon EC2 CLI</a>.
     * </p>
     * 
     * @param cancelConversionTaskRequest
     *        Contains the parameters for CancelConversionTask.
     * @return Result of the CancelConversionTask operation returned by the service.
     * @sample AmazonEC2.CancelConversionTask
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelConversionTask" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CancelConversionTaskResult cancelConversionTask(CancelConversionTaskRequest request) {
        request = beforeClientExecution(request);
        return executeCancelConversionTask(request);
    }

    @SdkInternalApi
    final CancelConversionTaskResult executeCancelConversionTask(CancelConversionTaskRequest cancelConversionTaskRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelConversionTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelConversionTaskRequest> request = null;
        Response<CancelConversionTaskResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelConversionTaskRequestMarshaller().marshall(super.beforeMarshalling(cancelConversionTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelConversionTask");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelConversionTaskResult> responseHandler = new StaxResponseHandler<CancelConversionTaskResult>(
                    new CancelConversionTaskResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels an active export task. The request removes all artifacts of the export, including any partially-created
     * Amazon S3 objects. If the export task is complete or is in the process of transferring the final disk image, the
     * command fails and returns an error.
     * </p>
     * 
     * @param cancelExportTaskRequest
     *        Contains the parameters for CancelExportTask.
     * @return Result of the CancelExportTask operation returned by the service.
     * @sample AmazonEC2.CancelExportTask
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelExportTask" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CancelExportTaskResult cancelExportTask(CancelExportTaskRequest request) {
        request = beforeClientExecution(request);
        return executeCancelExportTask(request);
    }

    @SdkInternalApi
    final CancelExportTaskResult executeCancelExportTask(CancelExportTaskRequest cancelExportTaskRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelExportTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelExportTaskRequest> request = null;
        Response<CancelExportTaskResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelExportTaskRequestMarshaller().marshall(super.beforeMarshalling(cancelExportTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelExportTask");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelExportTaskResult> responseHandler = new StaxResponseHandler<CancelExportTaskResult>(
                    new CancelExportTaskResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels an in-process import virtual machine or import snapshot task.
     * </p>
     * 
     * @param cancelImportTaskRequest
     *        Contains the parameters for CancelImportTask.
     * @return Result of the CancelImportTask operation returned by the service.
     * @sample AmazonEC2.CancelImportTask
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelImportTask" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CancelImportTaskResult cancelImportTask(CancelImportTaskRequest request) {
        request = beforeClientExecution(request);
        return executeCancelImportTask(request);
    }

    @SdkInternalApi
    final CancelImportTaskResult executeCancelImportTask(CancelImportTaskRequest cancelImportTaskRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelImportTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelImportTaskRequest> request = null;
        Response<CancelImportTaskResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelImportTaskRequestMarshaller().marshall(super.beforeMarshalling(cancelImportTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelImportTask");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelImportTaskResult> responseHandler = new StaxResponseHandler<CancelImportTaskResult>(
                    new CancelImportTaskResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public CancelImportTaskResult cancelImportTask() {
        return cancelImportTask(new CancelImportTaskRequest());
    }

    /**
     * <p>
     * Cancels the specified Reserved Instance listing in the Reserved Instance Marketplace.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-market-general.html">Reserved Instance
     * Marketplace</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param cancelReservedInstancesListingRequest
     *        Contains the parameters for CancelReservedInstancesListing.
     * @return Result of the CancelReservedInstancesListing operation returned by the service.
     * @sample AmazonEC2.CancelReservedInstancesListing
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelReservedInstancesListing"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CancelReservedInstancesListingResult cancelReservedInstancesListing(CancelReservedInstancesListingRequest request) {
        request = beforeClientExecution(request);
        return executeCancelReservedInstancesListing(request);
    }

    @SdkInternalApi
    final CancelReservedInstancesListingResult executeCancelReservedInstancesListing(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelReservedInstancesListingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelReservedInstancesListingRequest> request = null;
        Response<CancelReservedInstancesListingResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelReservedInstancesListingRequestMarshaller().marshall(super.beforeMarshalling(cancelReservedInstancesListingRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelReservedInstancesListing");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelReservedInstancesListingResult> responseHandler = new StaxResponseHandler<CancelReservedInstancesListingResult>(
                    new CancelReservedInstancesListingResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels the specified Spot Fleet requests.
     * </p>
     * <p>
     * After you cancel a Spot Fleet request, the Spot Fleet launches no new Spot Instances. You must specify whether
     * the Spot Fleet should also terminate its Spot Instances. If you terminate the instances, the Spot Fleet request
     * enters the <code>cancelled_terminating</code> state. Otherwise, the Spot Fleet request enters the
     * <code>cancelled_running</code> state and the instances continue to run until they are interrupted or you
     * terminate them manually.
     * </p>
     * 
     * @param cancelSpotFleetRequestsRequest
     *        Contains the parameters for CancelSpotFleetRequests.
     * @return Result of the CancelSpotFleetRequests operation returned by the service.
     * @sample AmazonEC2.CancelSpotFleetRequests
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelSpotFleetRequests" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CancelSpotFleetRequestsResult cancelSpotFleetRequests(CancelSpotFleetRequestsRequest request) {
        request = beforeClientExecution(request);
        return executeCancelSpotFleetRequests(request);
    }

    @SdkInternalApi
    final CancelSpotFleetRequestsResult executeCancelSpotFleetRequests(CancelSpotFleetRequestsRequest cancelSpotFleetRequestsRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelSpotFleetRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelSpotFleetRequestsRequest> request = null;
        Response<CancelSpotFleetRequestsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelSpotFleetRequestsRequestMarshaller().marshall(super.beforeMarshalling(cancelSpotFleetRequestsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelSpotFleetRequests");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelSpotFleetRequestsResult> responseHandler = new StaxResponseHandler<CancelSpotFleetRequestsResult>(
                    new CancelSpotFleetRequestsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Cancels one or more Spot Instance requests.
     * </p>
     * <important>
     * <p>
     * Canceling a Spot Instance request does not terminate running Spot Instances associated with the request.
     * </p>
     * </important>
     * 
     * @param cancelSpotInstanceRequestsRequest
     *        Contains the parameters for CancelSpotInstanceRequests.
     * @return Result of the CancelSpotInstanceRequests operation returned by the service.
     * @sample AmazonEC2.CancelSpotInstanceRequests
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CancelSpotInstanceRequests" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CancelSpotInstanceRequestsResult cancelSpotInstanceRequests(CancelSpotInstanceRequestsRequest request) {
        request = beforeClientExecution(request);
        return executeCancelSpotInstanceRequests(request);
    }

    @SdkInternalApi
    final CancelSpotInstanceRequestsResult executeCancelSpotInstanceRequests(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) {

        ExecutionContext executionContext = createExecutionContext(cancelSpotInstanceRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CancelSpotInstanceRequestsRequest> request = null;
        Response<CancelSpotInstanceRequestsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CancelSpotInstanceRequestsRequestMarshaller().marshall(super.beforeMarshalling(cancelSpotInstanceRequestsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelSpotInstanceRequests");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CancelSpotInstanceRequestsResult> responseHandler = new StaxResponseHandler<CancelSpotInstanceRequestsResult>(
                    new CancelSpotInstanceRequestsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Determines whether a product code is associated with an instance. This action can only be used by the owner of
     * the product code. It is useful when a product code owner must verify whether another user's instance is eligible
     * for support.
     * </p>
     * 
     * @param confirmProductInstanceRequest
     *        Contains the parameters for ConfirmProductInstance.
     * @return Result of the ConfirmProductInstance operation returned by the service.
     * @sample AmazonEC2.ConfirmProductInstance
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ConfirmProductInstance" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ConfirmProductInstanceResult confirmProductInstance(ConfirmProductInstanceRequest request) {
        request = beforeClientExecution(request);
        return executeConfirmProductInstance(request);
    }

    @SdkInternalApi
    final ConfirmProductInstanceResult executeConfirmProductInstance(ConfirmProductInstanceRequest confirmProductInstanceRequest) {

        ExecutionContext executionContext = createExecutionContext(confirmProductInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ConfirmProductInstanceRequest> request = null;
        Response<ConfirmProductInstanceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ConfirmProductInstanceRequestMarshaller().marshall(super.beforeMarshalling(confirmProductInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ConfirmProductInstance");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ConfirmProductInstanceResult> responseHandler = new StaxResponseHandler<ConfirmProductInstanceResult>(
                    new ConfirmProductInstanceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Copies the specified Amazon FPGA Image (AFI) to the current region.
     * </p>
     * 
     * @param copyFpgaImageRequest
     * @return Result of the CopyFpgaImage operation returned by the service.
     * @sample AmazonEC2.CopyFpgaImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CopyFpgaImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CopyFpgaImageResult copyFpgaImage(CopyFpgaImageRequest request) {
        request = beforeClientExecution(request);
        return executeCopyFpgaImage(request);
    }

    @SdkInternalApi
    final CopyFpgaImageResult executeCopyFpgaImage(CopyFpgaImageRequest copyFpgaImageRequest) {

        ExecutionContext executionContext = createExecutionContext(copyFpgaImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CopyFpgaImageRequest> request = null;
        Response<CopyFpgaImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CopyFpgaImageRequestMarshaller().marshall(super.beforeMarshalling(copyFpgaImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CopyFpgaImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CopyFpgaImageResult> responseHandler = new StaxResponseHandler<CopyFpgaImageResult>(new CopyFpgaImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Initiates the copy of an AMI from the specified source region to the current region. You specify the destination
     * region by using its endpoint when making the request.
     * </p>
     * <p>
     * Copies of encrypted backing snapshots for the AMI are encrypted. Copies of unencrypted backing snapshots remain
     * unencrypted, unless you set <code>Encrypted</code> during the copy operation. You cannot create an unencrypted
     * copy of an encrypted backing snapshot.
     * </p>
     * <p>
     * For more information about the prerequisites and limits when copying an AMI, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/CopyingAMIs.html">Copying an AMI</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param copyImageRequest
     *        Contains the parameters for CopyImage.
     * @return Result of the CopyImage operation returned by the service.
     * @sample AmazonEC2.CopyImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CopyImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CopyImageResult copyImage(CopyImageRequest request) {
        request = beforeClientExecution(request);
        return executeCopyImage(request);
    }

    @SdkInternalApi
    final CopyImageResult executeCopyImage(CopyImageRequest copyImageRequest) {

        ExecutionContext executionContext = createExecutionContext(copyImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CopyImageRequest> request = null;
        Response<CopyImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CopyImageRequestMarshaller().marshall(super.beforeMarshalling(copyImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CopyImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CopyImageResult> responseHandler = new StaxResponseHandler<CopyImageResult>(new CopyImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Copies a point-in-time snapshot of an EBS volume and stores it in Amazon S3. You can copy the snapshot within the
     * same region or from one region to another. You can use the snapshot to create EBS volumes or Amazon Machine
     * Images (AMIs). The snapshot is copied to the regional endpoint that you send the HTTP request to.
     * </p>
     * <p>
     * Copies of encrypted EBS snapshots remain encrypted. Copies of unencrypted snapshots remain unencrypted, unless
     * the <code>Encrypted</code> flag is specified during the snapshot copy operation. By default, encrypted snapshot
     * copies use the default AWS Key Management Service (AWS KMS) customer master key (CMK); however, you can specify a
     * non-default CMK with the <code>KmsKeyId</code> parameter.
     * </p>
     * <p>
     * To copy an encrypted snapshot that has been shared from another account, you must have permissions for the CMK
     * used to encrypt the snapshot.
     * </p>
     * <p>
     * Snapshots created by copying another snapshot have an arbitrary volume ID that should not be used for any
     * purpose.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-copy-snapshot.html">Copying an Amazon EBS
     * Snapshot</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param copySnapshotRequest
     *        Contains the parameters for CopySnapshot.
     * @return Result of the CopySnapshot operation returned by the service.
     * @sample AmazonEC2.CopySnapshot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CopySnapshot" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CopySnapshotResult copySnapshot(CopySnapshotRequest request) {
        request = beforeClientExecution(request);
        return executeCopySnapshot(request);
    }

    @SdkInternalApi
    final CopySnapshotResult executeCopySnapshot(CopySnapshotRequest copySnapshotRequest) {

        ExecutionContext executionContext = createExecutionContext(copySnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CopySnapshotRequest> request = null;
        Response<CopySnapshotResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CopySnapshotRequestMarshaller().marshall(super.beforeMarshalling(copySnapshotRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CopySnapshot");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CopySnapshotResult> responseHandler = new StaxResponseHandler<CopySnapshotResult>(new CopySnapshotResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a new Capacity Reservation with the specified attributes.
     * </p>
     * <p>
     * Capacity Reservations enable you to reserve capacity for your Amazon EC2 instances in a specific Availability
     * Zone for any duration. This gives you the flexibility to selectively add capacity reservations and still get the
     * Regional RI discounts for that usage. By creating Capacity Reservations, you ensure that you always have access
     * to Amazon EC2 capacity when you need it, for as long as you need it. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-capacity-reservations.html">Capacity
     * Reservations</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * Your request to create a Capacity Reservation could fail if Amazon EC2 does not have sufficient capacity to
     * fulfill the request. If your request fails due to Amazon EC2 capacity constraints, either try again at a later
     * time, try in a different Availability Zone, or request a smaller capacity reservation. If your application is
     * flexible across instance types and sizes, try to create a Capacity Reservation with different instance
     * attributes.
     * </p>
     * <p>
     * Your request could also fail if the requested quantity exceeds your On-Demand Instance limit for the selected
     * instance type. If your request fails due to limit constraints, increase your On-Demand Instance limit for the
     * required instance type and try again. For more information about increasing your instance limits, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-resource-limits.html">Amazon EC2 Service Limits</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createCapacityReservationRequest
     * @return Result of the CreateCapacityReservation operation returned by the service.
     * @sample AmazonEC2.CreateCapacityReservation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateCapacityReservation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateCapacityReservationResult createCapacityReservation(CreateCapacityReservationRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCapacityReservation(request);
    }

    @SdkInternalApi
    final CreateCapacityReservationResult executeCreateCapacityReservation(CreateCapacityReservationRequest createCapacityReservationRequest) {

        ExecutionContext executionContext = createExecutionContext(createCapacityReservationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCapacityReservationRequest> request = null;
        Response<CreateCapacityReservationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCapacityReservationRequestMarshaller().marshall(super.beforeMarshalling(createCapacityReservationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateCapacityReservation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateCapacityReservationResult> responseHandler = new StaxResponseHandler<CreateCapacityReservationResult>(
                    new CreateCapacityReservationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Provides information to AWS about your VPN customer gateway device. The customer gateway is the appliance at your
     * end of the VPN connection. (The device on the AWS side of the VPN connection is the virtual private gateway.) You
     * must provide the Internet-routable IP address of the customer gateway's external interface. The IP address must
     * be static and may be behind a device performing network address translation (NAT).
     * </p>
     * <p>
     * For devices that use Border Gateway Protocol (BGP), you can also provide the device's BGP Autonomous System
     * Number (ASN). You can use an existing ASN assigned to your network. If you don't have an ASN already, you can use
     * a private ASN (in the 64512 - 65534 range).
     * </p>
     * <note>
     * <p>
     * Amazon EC2 supports all 2-byte ASN numbers in the range of 1 - 65534, with the exception of 7224, which is
     * reserved in the <code>us-east-1</code> region, and 9059, which is reserved in the <code>eu-west-1</code> region.
     * </p>
     * </note>
     * <p>
     * For more information about VPN customer gateways, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <important>
     * <p>
     * You cannot create more than one customer gateway with the same VPN type, IP address, and BGP ASN parameter
     * values. If you run an identical request more than one time, the first request creates the customer gateway, and
     * subsequent requests return information about the existing customer gateway. The subsequent requests do not create
     * new customer gateway resources.
     * </p>
     * </important>
     * 
     * @param createCustomerGatewayRequest
     *        Contains the parameters for CreateCustomerGateway.
     * @return Result of the CreateCustomerGateway operation returned by the service.
     * @sample AmazonEC2.CreateCustomerGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateCustomerGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateCustomerGatewayResult createCustomerGateway(CreateCustomerGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateCustomerGateway(request);
    }

    @SdkInternalApi
    final CreateCustomerGatewayResult executeCreateCustomerGateway(CreateCustomerGatewayRequest createCustomerGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createCustomerGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateCustomerGatewayRequest> request = null;
        Response<CreateCustomerGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateCustomerGatewayRequestMarshaller().marshall(super.beforeMarshalling(createCustomerGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateCustomerGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateCustomerGatewayResult> responseHandler = new StaxResponseHandler<CreateCustomerGatewayResult>(
                    new CreateCustomerGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a default subnet with a size <code>/20</code> IPv4 CIDR block in the specified Availability Zone in your
     * default VPC. You can have only one default subnet per Availability Zone. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/default-vpc.html#create-default-subnet">Creating a
     * Default Subnet</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createDefaultSubnetRequest
     * @return Result of the CreateDefaultSubnet operation returned by the service.
     * @sample AmazonEC2.CreateDefaultSubnet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateDefaultSubnet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateDefaultSubnetResult createDefaultSubnet(CreateDefaultSubnetRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDefaultSubnet(request);
    }

    @SdkInternalApi
    final CreateDefaultSubnetResult executeCreateDefaultSubnet(CreateDefaultSubnetRequest createDefaultSubnetRequest) {

        ExecutionContext executionContext = createExecutionContext(createDefaultSubnetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDefaultSubnetRequest> request = null;
        Response<CreateDefaultSubnetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDefaultSubnetRequestMarshaller().marshall(super.beforeMarshalling(createDefaultSubnetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateDefaultSubnet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateDefaultSubnetResult> responseHandler = new StaxResponseHandler<CreateDefaultSubnetResult>(
                    new CreateDefaultSubnetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a default VPC with a size <code>/16</code> IPv4 CIDR block and a default subnet in each Availability
     * Zone. For more information about the components of a default VPC, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/default-vpc.html">Default VPC and Default Subnets</a>
     * in the <i>Amazon Virtual Private Cloud User Guide</i>. You cannot specify the components of the default VPC
     * yourself.
     * </p>
     * <p>
     * If you deleted your previous default VPC, you can create a default VPC. You cannot have more than one default VPC
     * per Region.
     * </p>
     * <p>
     * If your account supports EC2-Classic, you cannot use this action to create a default VPC in a Region that
     * supports EC2-Classic. If you want a default VPC in a Region that supports EC2-Classic, see
     * "I really want a default VPC for my existing EC2 account. Is that possible?" in the <a
     * href="http://aws.amazon.com/vpc/faqs/#Default_VPCs">Default VPCs FAQ</a>.
     * </p>
     * 
     * @param createDefaultVpcRequest
     * @return Result of the CreateDefaultVpc operation returned by the service.
     * @sample AmazonEC2.CreateDefaultVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateDefaultVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateDefaultVpcResult createDefaultVpc(CreateDefaultVpcRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDefaultVpc(request);
    }

    @SdkInternalApi
    final CreateDefaultVpcResult executeCreateDefaultVpc(CreateDefaultVpcRequest createDefaultVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(createDefaultVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDefaultVpcRequest> request = null;
        Response<CreateDefaultVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDefaultVpcRequestMarshaller().marshall(super.beforeMarshalling(createDefaultVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateDefaultVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateDefaultVpcResult> responseHandler = new StaxResponseHandler<CreateDefaultVpcResult>(
                    new CreateDefaultVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a set of DHCP options for your VPC. After creating the set, you must associate it with the VPC, causing
     * all existing and new instances that you launch in the VPC to use this set of DHCP options. The following are the
     * individual DHCP options you can specify. For more information about the options, see <a
     * href="http://www.ietf.org/rfc/rfc2132.txt">RFC 2132</a>.
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>domain-name-servers</code> - The IP addresses of up to four domain name servers, or AmazonProvidedDNS. The
     * default DHCP option set specifies AmazonProvidedDNS. If specifying more than one domain name server, specify the
     * IP addresses in a single parameter, separated by commas. ITo have your instance to receive a custom DNS hostname
     * as specified in <code>domain-name</code>, you must set <code>domain-name-servers</code> to a custom DNS server.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>domain-name</code> - If you're using AmazonProvidedDNS in <code>us-east-1</code>, specify
     * <code>ec2.internal</code>. If you're using AmazonProvidedDNS in another region, specify
     * <code>region.compute.internal</code> (for example, <code>ap-northeast-1.compute.internal</code>). Otherwise,
     * specify a domain name (for example, <code>MyCompany.com</code>). This value is used to complete unqualified DNS
     * hostnames. <b>Important</b>: Some Linux operating systems accept multiple domain names separated by spaces.
     * However, Windows and other Linux operating systems treat the value as a single domain, which results in
     * unexpected behavior. If your DHCP options set is associated with a VPC that has instances with multiple operating
     * systems, specify only one domain name.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ntp-servers</code> - The IP addresses of up to four Network Time Protocol (NTP) servers.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>netbios-name-servers</code> - The IP addresses of up to four NetBIOS name servers.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>netbios-node-type</code> - The NetBIOS node type (1, 2, 4, or 8). We recommend that you specify 2
     * (broadcast and multicast are not currently supported). For more information about these node types, see <a
     * href="http://www.ietf.org/rfc/rfc2132.txt">RFC 2132</a>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Your VPC automatically starts out with a set of DHCP options that includes only a DNS server that we provide
     * (AmazonProvidedDNS). If you create a set of options, and if your VPC has an internet gateway, make sure to set
     * the <code>domain-name-servers</code> option either to <code>AmazonProvidedDNS</code> or to a domain name server
     * of your choice. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_DHCP_Options.html">DHCP Options Sets</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createDhcpOptionsRequest
     * @return Result of the CreateDhcpOptions operation returned by the service.
     * @sample AmazonEC2.CreateDhcpOptions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateDhcpOptions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateDhcpOptionsResult createDhcpOptions(CreateDhcpOptionsRequest request) {
        request = beforeClientExecution(request);
        return executeCreateDhcpOptions(request);
    }

    @SdkInternalApi
    final CreateDhcpOptionsResult executeCreateDhcpOptions(CreateDhcpOptionsRequest createDhcpOptionsRequest) {

        ExecutionContext executionContext = createExecutionContext(createDhcpOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateDhcpOptionsRequest> request = null;
        Response<CreateDhcpOptionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateDhcpOptionsRequestMarshaller().marshall(super.beforeMarshalling(createDhcpOptionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateDhcpOptions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateDhcpOptionsResult> responseHandler = new StaxResponseHandler<CreateDhcpOptionsResult>(
                    new CreateDhcpOptionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * [IPv6 only] Creates an egress-only internet gateway for your VPC. An egress-only internet gateway is used to
     * enable outbound communication over IPv6 from instances in your VPC to the internet, and prevents hosts outside of
     * your VPC from initiating an IPv6 connection with your instance.
     * </p>
     * 
     * @param createEgressOnlyInternetGatewayRequest
     * @return Result of the CreateEgressOnlyInternetGateway operation returned by the service.
     * @sample AmazonEC2.CreateEgressOnlyInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateEgressOnlyInternetGateway"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateEgressOnlyInternetGatewayResult createEgressOnlyInternetGateway(CreateEgressOnlyInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateEgressOnlyInternetGateway(request);
    }

    @SdkInternalApi
    final CreateEgressOnlyInternetGatewayResult executeCreateEgressOnlyInternetGateway(
            CreateEgressOnlyInternetGatewayRequest createEgressOnlyInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createEgressOnlyInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateEgressOnlyInternetGatewayRequest> request = null;
        Response<CreateEgressOnlyInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateEgressOnlyInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(createEgressOnlyInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateEgressOnlyInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateEgressOnlyInternetGatewayResult> responseHandler = new StaxResponseHandler<CreateEgressOnlyInternetGatewayResult>(
                    new CreateEgressOnlyInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Launches an EC2 Fleet.
     * </p>
     * <p>
     * You can create a single EC2 Fleet that includes multiple launch specifications that vary by instance type, AMI,
     * Availability Zone, or subnet.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-fleet.html">Launching
     * an EC2 Fleet</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createFleetRequest
     * @return Result of the CreateFleet operation returned by the service.
     * @sample AmazonEC2.CreateFleet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateFleet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateFleetResult createFleet(CreateFleetRequest request) {
        request = beforeClientExecution(request);
        return executeCreateFleet(request);
    }

    @SdkInternalApi
    final CreateFleetResult executeCreateFleet(CreateFleetRequest createFleetRequest) {

        ExecutionContext executionContext = createExecutionContext(createFleetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFleetRequest> request = null;
        Response<CreateFleetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFleetRequestMarshaller().marshall(super.beforeMarshalling(createFleetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateFleet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateFleetResult> responseHandler = new StaxResponseHandler<CreateFleetResult>(new CreateFleetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates one or more flow logs to capture information about IP traffic for a specific network interface, subnet,
     * or VPC.
     * </p>
     * <p>
     * Flow log data for a monitored network interface is recorded as flow log records, which are log events consisting
     * of fields that describe the traffic flow. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/flow-logs.html#flow-log-records">Flow Log Records</a>
     * in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * When publishing to CloudWatch Logs, flow log records are published to a log group, and each network interface has
     * a unique log stream in the log group. When publishing to Amazon S3, flow log records for all of the monitored
     * network interfaces are published to a single log file object that is stored in the specified bucket.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/flow-logs.html">VPC Flow
     * Logs</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createFlowLogsRequest
     * @return Result of the CreateFlowLogs operation returned by the service.
     * @sample AmazonEC2.CreateFlowLogs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateFlowLogs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateFlowLogsResult createFlowLogs(CreateFlowLogsRequest request) {
        request = beforeClientExecution(request);
        return executeCreateFlowLogs(request);
    }

    @SdkInternalApi
    final CreateFlowLogsResult executeCreateFlowLogs(CreateFlowLogsRequest createFlowLogsRequest) {

        ExecutionContext executionContext = createExecutionContext(createFlowLogsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFlowLogsRequest> request = null;
        Response<CreateFlowLogsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFlowLogsRequestMarshaller().marshall(super.beforeMarshalling(createFlowLogsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateFlowLogs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateFlowLogsResult> responseHandler = new StaxResponseHandler<CreateFlowLogsResult>(
                    new CreateFlowLogsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an Amazon FPGA Image (AFI) from the specified design checkpoint (DCP).
     * </p>
     * <p>
     * The create operation is asynchronous. To verify that the AFI is ready for use, check the output logs.
     * </p>
     * <p>
     * An AFI contains the FPGA bitstream that is ready to download to an FPGA. You can securely deploy an AFI on one or
     * more FPGA-accelerated instances. For more information, see the <a href="https://github.com/aws/aws-fpga/">AWS
     * FPGA Hardware Development Kit</a>.
     * </p>
     * 
     * @param createFpgaImageRequest
     * @return Result of the CreateFpgaImage operation returned by the service.
     * @sample AmazonEC2.CreateFpgaImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateFpgaImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateFpgaImageResult createFpgaImage(CreateFpgaImageRequest request) {
        request = beforeClientExecution(request);
        return executeCreateFpgaImage(request);
    }

    @SdkInternalApi
    final CreateFpgaImageResult executeCreateFpgaImage(CreateFpgaImageRequest createFpgaImageRequest) {

        ExecutionContext executionContext = createExecutionContext(createFpgaImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateFpgaImageRequest> request = null;
        Response<CreateFpgaImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateFpgaImageRequestMarshaller().marshall(super.beforeMarshalling(createFpgaImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateFpgaImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateFpgaImageResult> responseHandler = new StaxResponseHandler<CreateFpgaImageResult>(
                    new CreateFpgaImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an Amazon EBS-backed AMI from an Amazon EBS-backed instance that is either running or stopped.
     * </p>
     * <p>
     * If you customized your instance with instance store volumes or EBS volumes in addition to the root device volume,
     * the new AMI contains block device mapping information for those volumes. When you launch an instance from this
     * new AMI, the instance automatically launches with those additional volumes.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-ebs.html">Creating Amazon EBS-Backed
     * Linux AMIs</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createImageRequest
     *        Contains the parameters for CreateImage.
     * @return Result of the CreateImage operation returned by the service.
     * @sample AmazonEC2.CreateImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateImageResult createImage(CreateImageRequest request) {
        request = beforeClientExecution(request);
        return executeCreateImage(request);
    }

    @SdkInternalApi
    final CreateImageResult executeCreateImage(CreateImageRequest createImageRequest) {

        ExecutionContext executionContext = createExecutionContext(createImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateImageRequest> request = null;
        Response<CreateImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateImageRequestMarshaller().marshall(super.beforeMarshalling(createImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateImageResult> responseHandler = new StaxResponseHandler<CreateImageResult>(new CreateImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Exports a running or stopped instance to an S3 bucket.
     * </p>
     * <p>
     * For information about the supported operating systems, image formats, and known limitations for the types of
     * instances you can export, see <a
     * href="http://docs.aws.amazon.com/vm-import/latest/userguide/vmexport.html">Exporting an Instance as a VM Using VM
     * Import/Export</a> in the <i>VM Import/Export User Guide</i>.
     * </p>
     * 
     * @param createInstanceExportTaskRequest
     *        Contains the parameters for CreateInstanceExportTask.
     * @return Result of the CreateInstanceExportTask operation returned by the service.
     * @sample AmazonEC2.CreateInstanceExportTask
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateInstanceExportTask" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateInstanceExportTaskResult createInstanceExportTask(CreateInstanceExportTaskRequest request) {
        request = beforeClientExecution(request);
        return executeCreateInstanceExportTask(request);
    }

    @SdkInternalApi
    final CreateInstanceExportTaskResult executeCreateInstanceExportTask(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) {

        ExecutionContext executionContext = createExecutionContext(createInstanceExportTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateInstanceExportTaskRequest> request = null;
        Response<CreateInstanceExportTaskResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateInstanceExportTaskRequestMarshaller().marshall(super.beforeMarshalling(createInstanceExportTaskRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateInstanceExportTask");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateInstanceExportTaskResult> responseHandler = new StaxResponseHandler<CreateInstanceExportTaskResult>(
                    new CreateInstanceExportTaskResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an internet gateway for use with a VPC. After creating the internet gateway, you attach it to a VPC using
     * <a>AttachInternetGateway</a>.
     * </p>
     * <p>
     * For more information about your VPC and internet gateway, see the <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/">Amazon Virtual Private Cloud User Guide</a>.
     * </p>
     * 
     * @param createInternetGatewayRequest
     * @return Result of the CreateInternetGateway operation returned by the service.
     * @sample AmazonEC2.CreateInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateInternetGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateInternetGatewayResult createInternetGateway(CreateInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateInternetGateway(request);
    }

    @SdkInternalApi
    final CreateInternetGatewayResult executeCreateInternetGateway(CreateInternetGatewayRequest createInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateInternetGatewayRequest> request = null;
        Response<CreateInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(createInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateInternetGatewayResult> responseHandler = new StaxResponseHandler<CreateInternetGatewayResult>(
                    new CreateInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public CreateInternetGatewayResult createInternetGateway() {
        return createInternetGateway(new CreateInternetGatewayRequest());
    }

    /**
     * <p>
     * Creates a 2048-bit RSA key pair with the specified name. Amazon EC2 stores the public key and displays the
     * private key for you to save to a file. The private key is returned as an unencrypted PEM encoded PKCS#1 private
     * key. If a key with the specified name already exists, Amazon EC2 returns an error.
     * </p>
     * <p>
     * You can have up to five thousand key pairs per region.
     * </p>
     * <p>
     * The key pair returned to you is available only in the region in which you create it. If you prefer, you can
     * create your own key pair using a third-party tool and upload it to any region using <a>ImportKeyPair</a>.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html">Key
     * Pairs</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createKeyPairRequest
     * @return Result of the CreateKeyPair operation returned by the service.
     * @sample AmazonEC2.CreateKeyPair
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateKeyPair" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateKeyPairResult createKeyPair(CreateKeyPairRequest request) {
        request = beforeClientExecution(request);
        return executeCreateKeyPair(request);
    }

    @SdkInternalApi
    final CreateKeyPairResult executeCreateKeyPair(CreateKeyPairRequest createKeyPairRequest) {

        ExecutionContext executionContext = createExecutionContext(createKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateKeyPairRequest> request = null;
        Response<CreateKeyPairResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateKeyPairRequestMarshaller().marshall(super.beforeMarshalling(createKeyPairRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateKeyPair");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateKeyPairResult> responseHandler = new StaxResponseHandler<CreateKeyPairResult>(new CreateKeyPairResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a launch template. A launch template contains the parameters to launch an instance. When you launch an
     * instance using <a>RunInstances</a>, you can specify a launch template instead of providing the launch parameters
     * in the request.
     * </p>
     * 
     * @param createLaunchTemplateRequest
     * @return Result of the CreateLaunchTemplate operation returned by the service.
     * @sample AmazonEC2.CreateLaunchTemplate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateLaunchTemplate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateLaunchTemplateResult createLaunchTemplate(CreateLaunchTemplateRequest request) {
        request = beforeClientExecution(request);
        return executeCreateLaunchTemplate(request);
    }

    @SdkInternalApi
    final CreateLaunchTemplateResult executeCreateLaunchTemplate(CreateLaunchTemplateRequest createLaunchTemplateRequest) {

        ExecutionContext executionContext = createExecutionContext(createLaunchTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateLaunchTemplateRequest> request = null;
        Response<CreateLaunchTemplateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateLaunchTemplateRequestMarshaller().marshall(super.beforeMarshalling(createLaunchTemplateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateLaunchTemplate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateLaunchTemplateResult> responseHandler = new StaxResponseHandler<CreateLaunchTemplateResult>(
                    new CreateLaunchTemplateResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a new version for a launch template. You can specify an existing version of launch template from which to
     * base the new version.
     * </p>
     * <p>
     * Launch template versions are numbered in the order in which they are created. You cannot specify, change, or
     * replace the numbering of launch template versions.
     * </p>
     * 
     * @param createLaunchTemplateVersionRequest
     * @return Result of the CreateLaunchTemplateVersion operation returned by the service.
     * @sample AmazonEC2.CreateLaunchTemplateVersion
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateLaunchTemplateVersion"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateLaunchTemplateVersionResult createLaunchTemplateVersion(CreateLaunchTemplateVersionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateLaunchTemplateVersion(request);
    }

    @SdkInternalApi
    final CreateLaunchTemplateVersionResult executeCreateLaunchTemplateVersion(CreateLaunchTemplateVersionRequest createLaunchTemplateVersionRequest) {

        ExecutionContext executionContext = createExecutionContext(createLaunchTemplateVersionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateLaunchTemplateVersionRequest> request = null;
        Response<CreateLaunchTemplateVersionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateLaunchTemplateVersionRequestMarshaller().marshall(super.beforeMarshalling(createLaunchTemplateVersionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateLaunchTemplateVersion");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateLaunchTemplateVersionResult> responseHandler = new StaxResponseHandler<CreateLaunchTemplateVersionResult>(
                    new CreateLaunchTemplateVersionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a NAT gateway in the specified public subnet. This action creates a network interface in the specified
     * subnet with a private IP address from the IP address range of the subnet. Internet-bound traffic from a private
     * subnet can be routed to the NAT gateway, therefore enabling instances in the private subnet to connect to the
     * internet. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/vpc-nat-gateway.html">NAT Gateways</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createNatGatewayRequest
     * @return Result of the CreateNatGateway operation returned by the service.
     * @sample AmazonEC2.CreateNatGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateNatGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateNatGatewayResult createNatGateway(CreateNatGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateNatGateway(request);
    }

    @SdkInternalApi
    final CreateNatGatewayResult executeCreateNatGateway(CreateNatGatewayRequest createNatGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createNatGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateNatGatewayRequest> request = null;
        Response<CreateNatGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateNatGatewayRequestMarshaller().marshall(super.beforeMarshalling(createNatGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateNatGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateNatGatewayResult> responseHandler = new StaxResponseHandler<CreateNatGatewayResult>(
                    new CreateNatGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a network ACL in a VPC. Network ACLs provide an optional layer of security (in addition to security
     * groups) for the instances in your VPC.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html">Network
     * ACLs</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createNetworkAclRequest
     * @return Result of the CreateNetworkAcl operation returned by the service.
     * @sample AmazonEC2.CreateNetworkAcl
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateNetworkAcl" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateNetworkAclResult createNetworkAcl(CreateNetworkAclRequest request) {
        request = beforeClientExecution(request);
        return executeCreateNetworkAcl(request);
    }

    @SdkInternalApi
    final CreateNetworkAclResult executeCreateNetworkAcl(CreateNetworkAclRequest createNetworkAclRequest) {

        ExecutionContext executionContext = createExecutionContext(createNetworkAclRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateNetworkAclRequest> request = null;
        Response<CreateNetworkAclResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateNetworkAclRequestMarshaller().marshall(super.beforeMarshalling(createNetworkAclRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateNetworkAcl");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateNetworkAclResult> responseHandler = new StaxResponseHandler<CreateNetworkAclResult>(
                    new CreateNetworkAclResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an entry (a rule) in a network ACL with the specified rule number. Each network ACL has a set of numbered
     * ingress rules and a separate set of numbered egress rules. When determining whether a packet should be allowed in
     * or out of a subnet associated with the ACL, we process the entries in the ACL according to the rule numbers, in
     * ascending order. Each network ACL has a set of ingress rules and a separate set of egress rules.
     * </p>
     * <p>
     * We recommend that you leave room between the rule numbers (for example, 100, 110, 120, ...), and not number them
     * one right after the other (for example, 101, 102, 103, ...). This makes it easier to add a rule between existing
     * ones without having to renumber the rules.
     * </p>
     * <p>
     * After you add an entry, you can't modify it; you must either replace it, or create an entry and delete the old
     * one.
     * </p>
     * <p>
     * For more information about network ACLs, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html">Network ACLs</a> in the <i>Amazon
     * Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createNetworkAclEntryRequest
     * @return Result of the CreateNetworkAclEntry operation returned by the service.
     * @sample AmazonEC2.CreateNetworkAclEntry
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateNetworkAclEntry" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateNetworkAclEntryResult createNetworkAclEntry(CreateNetworkAclEntryRequest request) {
        request = beforeClientExecution(request);
        return executeCreateNetworkAclEntry(request);
    }

    @SdkInternalApi
    final CreateNetworkAclEntryResult executeCreateNetworkAclEntry(CreateNetworkAclEntryRequest createNetworkAclEntryRequest) {

        ExecutionContext executionContext = createExecutionContext(createNetworkAclEntryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateNetworkAclEntryRequest> request = null;
        Response<CreateNetworkAclEntryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateNetworkAclEntryRequestMarshaller().marshall(super.beforeMarshalling(createNetworkAclEntryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateNetworkAclEntry");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateNetworkAclEntryResult> responseHandler = new StaxResponseHandler<CreateNetworkAclEntryResult>(
                    new CreateNetworkAclEntryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a network interface in the specified subnet.
     * </p>
     * <p>
     * For more information about network interfaces, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html">Elastic Network Interfaces</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createNetworkInterfaceRequest
     *        Contains the parameters for CreateNetworkInterface.
     * @return Result of the CreateNetworkInterface operation returned by the service.
     * @sample AmazonEC2.CreateNetworkInterface
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateNetworkInterface" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateNetworkInterfaceResult createNetworkInterface(CreateNetworkInterfaceRequest request) {
        request = beforeClientExecution(request);
        return executeCreateNetworkInterface(request);
    }

    @SdkInternalApi
    final CreateNetworkInterfaceResult executeCreateNetworkInterface(CreateNetworkInterfaceRequest createNetworkInterfaceRequest) {

        ExecutionContext executionContext = createExecutionContext(createNetworkInterfaceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateNetworkInterfaceRequest> request = null;
        Response<CreateNetworkInterfaceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateNetworkInterfaceRequestMarshaller().marshall(super.beforeMarshalling(createNetworkInterfaceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateNetworkInterface");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateNetworkInterfaceResult> responseHandler = new StaxResponseHandler<CreateNetworkInterfaceResult>(
                    new CreateNetworkInterfaceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Grants an AWS-authorized account permission to attach the specified network interface to an instance in their
     * account.
     * </p>
     * <p>
     * You can grant permission to a single AWS account only, and only one account at a time.
     * </p>
     * 
     * @param createNetworkInterfacePermissionRequest
     *        Contains the parameters for CreateNetworkInterfacePermission.
     * @return Result of the CreateNetworkInterfacePermission operation returned by the service.
     * @sample AmazonEC2.CreateNetworkInterfacePermission
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateNetworkInterfacePermission"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateNetworkInterfacePermissionResult createNetworkInterfacePermission(CreateNetworkInterfacePermissionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateNetworkInterfacePermission(request);
    }

    @SdkInternalApi
    final CreateNetworkInterfacePermissionResult executeCreateNetworkInterfacePermission(
            CreateNetworkInterfacePermissionRequest createNetworkInterfacePermissionRequest) {

        ExecutionContext executionContext = createExecutionContext(createNetworkInterfacePermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateNetworkInterfacePermissionRequest> request = null;
        Response<CreateNetworkInterfacePermissionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateNetworkInterfacePermissionRequestMarshaller().marshall(super.beforeMarshalling(createNetworkInterfacePermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateNetworkInterfacePermission");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateNetworkInterfacePermissionResult> responseHandler = new StaxResponseHandler<CreateNetworkInterfacePermissionResult>(
                    new CreateNetworkInterfacePermissionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a placement group in which to launch instances. The strategy of the placement group determines how the
     * instances are organized within the group.
     * </p>
     * <p>
     * A <code>cluster</code> placement group is a logical grouping of instances within a single Availability Zone that
     * benefit from low network latency, high network throughput. A <code>spread</code> placement group places instances
     * on distinct hardware.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html">Placement Groups</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createPlacementGroupRequest
     *        Contains the parameters for CreatePlacementGroup.
     * @return Result of the CreatePlacementGroup operation returned by the service.
     * @sample AmazonEC2.CreatePlacementGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreatePlacementGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreatePlacementGroupResult createPlacementGroup(CreatePlacementGroupRequest request) {
        request = beforeClientExecution(request);
        return executeCreatePlacementGroup(request);
    }

    @SdkInternalApi
    final CreatePlacementGroupResult executeCreatePlacementGroup(CreatePlacementGroupRequest createPlacementGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(createPlacementGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreatePlacementGroupRequest> request = null;
        Response<CreatePlacementGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreatePlacementGroupRequestMarshaller().marshall(super.beforeMarshalling(createPlacementGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreatePlacementGroup");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreatePlacementGroupResult> responseHandler = new StaxResponseHandler<CreatePlacementGroupResult>(
                    new CreatePlacementGroupResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a listing for Amazon EC2 Standard Reserved Instances to be sold in the Reserved Instance Marketplace. You
     * can submit one Standard Reserved Instance listing at a time. To get a list of your Standard Reserved Instances,
     * you can use the <a>DescribeReservedInstances</a> operation.
     * </p>
     * <note>
     * <p>
     * Only Standard Reserved Instances with a capacity reservation can be sold in the Reserved Instance Marketplace.
     * Convertible Reserved Instances and Standard Reserved Instances with a regional benefit cannot be sold.
     * </p>
     * </note>
     * <p>
     * The Reserved Instance Marketplace matches sellers who want to resell Standard Reserved Instance capacity that
     * they no longer need with buyers who want to purchase additional capacity. Reserved Instances bought and sold
     * through the Reserved Instance Marketplace work like any other Reserved Instances.
     * </p>
     * <p>
     * To sell your Standard Reserved Instances, you must first register as a seller in the Reserved Instance
     * Marketplace. After completing the registration process, you can create a Reserved Instance Marketplace listing of
     * some or all of your Standard Reserved Instances, and specify the upfront price to receive for them. Your Standard
     * Reserved Instance listings then become available for purchase. To view the details of your Standard Reserved
     * Instance listing, you can use the <a>DescribeReservedInstancesListings</a> operation.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-market-general.html">Reserved Instance
     * Marketplace</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createReservedInstancesListingRequest
     *        Contains the parameters for CreateReservedInstancesListing.
     * @return Result of the CreateReservedInstancesListing operation returned by the service.
     * @sample AmazonEC2.CreateReservedInstancesListing
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateReservedInstancesListing"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateReservedInstancesListingResult createReservedInstancesListing(CreateReservedInstancesListingRequest request) {
        request = beforeClientExecution(request);
        return executeCreateReservedInstancesListing(request);
    }

    @SdkInternalApi
    final CreateReservedInstancesListingResult executeCreateReservedInstancesListing(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) {

        ExecutionContext executionContext = createExecutionContext(createReservedInstancesListingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateReservedInstancesListingRequest> request = null;
        Response<CreateReservedInstancesListingResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateReservedInstancesListingRequestMarshaller().marshall(super.beforeMarshalling(createReservedInstancesListingRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateReservedInstancesListing");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateReservedInstancesListingResult> responseHandler = new StaxResponseHandler<CreateReservedInstancesListingResult>(
                    new CreateReservedInstancesListingResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a route in a route table within a VPC.
     * </p>
     * <p>
     * You must specify one of the following targets: internet gateway or virtual private gateway, NAT instance, NAT
     * gateway, VPC peering connection, network interface, or egress-only internet gateway.
     * </p>
     * <p>
     * When determining how to route traffic, we use the route with the most specific match. For example, traffic is
     * destined for the IPv4 address <code>192.0.2.3</code>, and the route table includes the following two IPv4 routes:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>192.0.2.0/24</code> (goes to some target A)
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>192.0.2.0/28</code> (goes to some target B)
     * </p>
     * </li>
     * </ul>
     * <p>
     * Both routes apply to the traffic destined for <code>192.0.2.3</code>. However, the second route in the list
     * covers a smaller number of IP addresses and is therefore more specific, so we use that route to determine where
     * to target the traffic.
     * </p>
     * <p>
     * For more information about route tables, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createRouteRequest
     * @return Result of the CreateRoute operation returned by the service.
     * @sample AmazonEC2.CreateRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateRoute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateRouteResult createRoute(CreateRouteRequest request) {
        request = beforeClientExecution(request);
        return executeCreateRoute(request);
    }

    @SdkInternalApi
    final CreateRouteResult executeCreateRoute(CreateRouteRequest createRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(createRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateRouteRequest> request = null;
        Response<CreateRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateRouteRequestMarshaller().marshall(super.beforeMarshalling(createRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateRouteResult> responseHandler = new StaxResponseHandler<CreateRouteResult>(new CreateRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a route table for the specified VPC. After you create a route table, you can add routes and associate the
     * table with a subnet.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createRouteTableRequest
     * @return Result of the CreateRouteTable operation returned by the service.
     * @sample AmazonEC2.CreateRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateRouteTable" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateRouteTableResult createRouteTable(CreateRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeCreateRouteTable(request);
    }

    @SdkInternalApi
    final CreateRouteTableResult executeCreateRouteTable(CreateRouteTableRequest createRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(createRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateRouteTableRequest> request = null;
        Response<CreateRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateRouteTableRequestMarshaller().marshall(super.beforeMarshalling(createRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateRouteTableResult> responseHandler = new StaxResponseHandler<CreateRouteTableResult>(
                    new CreateRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a security group.
     * </p>
     * <p>
     * A security group is for use with instances either in the EC2-Classic platform or in a specific VPC. For more
     * information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html">Amazon
     * EC2 Security Groups</a> in the <i>Amazon Elastic Compute Cloud User Guide</i> and <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html">Security Groups for Your
     * VPC</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <important>
     * <p>
     * EC2-Classic: You can have up to 500 security groups.
     * </p>
     * <p>
     * EC2-VPC: You can create up to 500 security groups per VPC.
     * </p>
     * </important>
     * <p>
     * When you create a security group, you specify a friendly name of your choice. You can have a security group for
     * use in EC2-Classic with the same name as a security group for use in a VPC. However, you can't have two security
     * groups for use in EC2-Classic with the same name or two security groups for use in a VPC with the same name.
     * </p>
     * <p>
     * You have a default security group for use in EC2-Classic and a default security group for use in your VPC. If you
     * don't specify a security group when you launch an instance, the instance is launched into the appropriate default
     * security group. A default security group includes a default rule that grants instances unrestricted network
     * access to each other.
     * </p>
     * <p>
     * You can add or remove rules from your security groups using <a>AuthorizeSecurityGroupIngress</a>,
     * <a>AuthorizeSecurityGroupEgress</a>, <a>RevokeSecurityGroupIngress</a>, and <a>RevokeSecurityGroupEgress</a>.
     * </p>
     * 
     * @param createSecurityGroupRequest
     * @return Result of the CreateSecurityGroup operation returned by the service.
     * @sample AmazonEC2.CreateSecurityGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateSecurityGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateSecurityGroupResult createSecurityGroup(CreateSecurityGroupRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSecurityGroup(request);
    }

    @SdkInternalApi
    final CreateSecurityGroupResult executeCreateSecurityGroup(CreateSecurityGroupRequest createSecurityGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(createSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSecurityGroupRequest> request = null;
        Response<CreateSecurityGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSecurityGroupRequestMarshaller().marshall(super.beforeMarshalling(createSecurityGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSecurityGroup");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateSecurityGroupResult> responseHandler = new StaxResponseHandler<CreateSecurityGroupResult>(
                    new CreateSecurityGroupResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a snapshot of an EBS volume and stores it in Amazon S3. You can use snapshots for backups, to make copies
     * of EBS volumes, and to save data before shutting down an instance.
     * </p>
     * <p>
     * When a snapshot is created, any AWS Marketplace product codes that are associated with the source volume are
     * propagated to the snapshot.
     * </p>
     * <p>
     * You can take a snapshot of an attached volume that is in use. However, snapshots only capture data that has been
     * written to your EBS volume at the time the snapshot command is issued; this may exclude any data that has been
     * cached by any applications or the operating system. If you can pause any file systems on the volume long enough
     * to take a snapshot, your snapshot should be complete. However, if you cannot pause all file writes to the volume,
     * you should unmount the volume from within the instance, issue the snapshot command, and then remount the volume
     * to ensure a consistent and complete snapshot. You may remount and use your volume while the snapshot status is
     * <code>pending</code>.
     * </p>
     * <p>
     * To create a snapshot for EBS volumes that serve as root devices, you should stop the instance before taking the
     * snapshot.
     * </p>
     * <p>
     * Snapshots that are taken from encrypted volumes are automatically encrypted. Volumes that are created from
     * encrypted snapshots are also automatically encrypted. Your encrypted volumes and any associated snapshots always
     * remain protected.
     * </p>
     * <p>
     * You can tag your snapshots during creation. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Amazon EC2 Resources</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AmazonEBS.html">Amazon
     * Elastic Block Store</a> and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html">Amazon EBS Encryption</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createSnapshotRequest
     *        Contains the parameters for CreateSnapshot.
     * @return Result of the CreateSnapshot operation returned by the service.
     * @sample AmazonEC2.CreateSnapshot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateSnapshot" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSnapshot(request);
    }

    @SdkInternalApi
    final CreateSnapshotResult executeCreateSnapshot(CreateSnapshotRequest createSnapshotRequest) {

        ExecutionContext executionContext = createExecutionContext(createSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSnapshotRequest> request = null;
        Response<CreateSnapshotResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSnapshotRequestMarshaller().marshall(super.beforeMarshalling(createSnapshotRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSnapshot");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateSnapshotResult> responseHandler = new StaxResponseHandler<CreateSnapshotResult>(
                    new CreateSnapshotResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a data feed for Spot Instances, enabling you to view Spot Instance usage logs. You can create one data
     * feed per AWS account. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-data-feeds.html">Spot Instance Data Feed</a> in the
     * <i>Amazon EC2 User Guide for Linux Instances</i>.
     * </p>
     * 
     * @param createSpotDatafeedSubscriptionRequest
     *        Contains the parameters for CreateSpotDatafeedSubscription.
     * @return Result of the CreateSpotDatafeedSubscription operation returned by the service.
     * @sample AmazonEC2.CreateSpotDatafeedSubscription
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateSpotDatafeedSubscription"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscription(CreateSpotDatafeedSubscriptionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSpotDatafeedSubscription(request);
    }

    @SdkInternalApi
    final CreateSpotDatafeedSubscriptionResult executeCreateSpotDatafeedSubscription(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) {

        ExecutionContext executionContext = createExecutionContext(createSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSpotDatafeedSubscriptionRequest> request = null;
        Response<CreateSpotDatafeedSubscriptionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSpotDatafeedSubscriptionRequestMarshaller().marshall(super.beforeMarshalling(createSpotDatafeedSubscriptionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSpotDatafeedSubscription");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateSpotDatafeedSubscriptionResult> responseHandler = new StaxResponseHandler<CreateSpotDatafeedSubscriptionResult>(
                    new CreateSpotDatafeedSubscriptionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a subnet in an existing VPC.
     * </p>
     * <p>
     * When you create each subnet, you provide the VPC ID and IPv4 CIDR block for the subnet. After you create a
     * subnet, you can't change its CIDR block. The size of the subnet's IPv4 CIDR block can be the same as a VPC's IPv4
     * CIDR block, or a subset of a VPC's IPv4 CIDR block. If you create more than one subnet in a VPC, the subnets'
     * CIDR blocks must not overlap. The smallest IPv4 subnet (and VPC) you can create uses a /28 netmask (16 IPv4
     * addresses), and the largest uses a /16 netmask (65,536 IPv4 addresses).
     * </p>
     * <p>
     * If you've associated an IPv6 CIDR block with your VPC, you can create a subnet with an IPv6 CIDR block that uses
     * a /64 prefix length.
     * </p>
     * <important>
     * <p>
     * AWS reserves both the first four and the last IPv4 address in each subnet's CIDR block. They're not available for
     * use.
     * </p>
     * </important>
     * <p>
     * If you add more than one subnet to a VPC, they're set up in a star topology with a logical router in the middle.
     * </p>
     * <p>
     * If you launch an instance in a VPC using an Amazon EBS-backed AMI, the IP address doesn't change if you stop and
     * restart the instance (unlike a similar instance launched outside a VPC, which gets a new IP address when
     * restarted). It's therefore possible to have a subnet with no running instances (they're all stopped), but no
     * remaining IP addresses available.
     * </p>
     * <p>
     * For more information about subnets, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Subnets.html">Your VPC and Subnets</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createSubnetRequest
     * @return Result of the CreateSubnet operation returned by the service.
     * @sample AmazonEC2.CreateSubnet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateSubnet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateSubnetResult createSubnet(CreateSubnetRequest request) {
        request = beforeClientExecution(request);
        return executeCreateSubnet(request);
    }

    @SdkInternalApi
    final CreateSubnetResult executeCreateSubnet(CreateSubnetRequest createSubnetRequest) {

        ExecutionContext executionContext = createExecutionContext(createSubnetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateSubnetRequest> request = null;
        Response<CreateSubnetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateSubnetRequestMarshaller().marshall(super.beforeMarshalling(createSubnetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSubnet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateSubnetResult> responseHandler = new StaxResponseHandler<CreateSubnetResult>(new CreateSubnetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Adds or overwrites one or more tags for the specified Amazon EC2 resource or resources. Each resource can have a
     * maximum of 50 tags. Each tag consists of a key and optional value. Tag keys must be unique per resource.
     * </p>
     * <p>
     * For more information about tags, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Resources</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>. For more information about creating IAM policies that control
     * users' access to resources based on tags, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-supported-iam-actions-resources.html">Supported
     * Resource-Level Permissions for Amazon EC2 API Actions</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createTagsRequest
     * @return Result of the CreateTags operation returned by the service.
     * @sample AmazonEC2.CreateTags
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateTags" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateTagsResult createTags(CreateTagsRequest request) {
        request = beforeClientExecution(request);
        return executeCreateTags(request);
    }

    @SdkInternalApi
    final CreateTagsResult executeCreateTags(CreateTagsRequest createTagsRequest) {

        ExecutionContext executionContext = createExecutionContext(createTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTagsRequest> request = null;
        Response<CreateTagsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTagsRequestMarshaller().marshall(super.beforeMarshalling(createTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTags");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateTagsResult> responseHandler = new StaxResponseHandler<CreateTagsResult>(new CreateTagsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a transit gateway.
     * </p>
     * <p>
     * You can use a transit gateway to interconnect your virtual private clouds (VPC) and on-premises networks. After
     * the transit gateway enters the <code>available</code> state, you can attach your VPCs and VPN connections to the
     * transit gateway.
     * </p>
     * <p>
     * To attach your VPCs, use <a>CreateTransitGatewayVpcAttachment</a>.
     * </p>
     * <p>
     * To attach a VPN connection, use <a>CreateCustomerGateway</a> to create a customer gateway and specify the ID of
     * the customer gateway and the ID of the transit gateway in a call to <a>CreateVpnConnection</a>.
     * </p>
     * <p>
     * When you create a transit gateway, we create a default transit gateway route table and use it as the default
     * association route table and the default propagation route table. You can use
     * <a>CreateTransitGatewayRouteTable</a> to create additional transit gateway route tables. If you disable automatic
     * route propagation, we do not create a default transit gateway route table. You can use
     * <a>EnableTransitGatewayRouteTablePropagation</a> to propagate routes from a resource attachment to a transit
     * gateway route table. If you disable automatic associations, you can use <a>AssociateTransitGatewayRouteTable</a>
     * to associate a resource attachment with a transit gateway route table.
     * </p>
     * 
     * @param createTransitGatewayRequest
     * @return Result of the CreateTransitGateway operation returned by the service.
     * @sample AmazonEC2.CreateTransitGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateTransitGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateTransitGatewayResult createTransitGateway(CreateTransitGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateTransitGateway(request);
    }

    @SdkInternalApi
    final CreateTransitGatewayResult executeCreateTransitGateway(CreateTransitGatewayRequest createTransitGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createTransitGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTransitGatewayRequest> request = null;
        Response<CreateTransitGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTransitGatewayRequestMarshaller().marshall(super.beforeMarshalling(createTransitGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTransitGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateTransitGatewayResult> responseHandler = new StaxResponseHandler<CreateTransitGatewayResult>(
                    new CreateTransitGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a static route for the specified transit gateway route table.
     * </p>
     * 
     * @param createTransitGatewayRouteRequest
     * @return Result of the CreateTransitGatewayRoute operation returned by the service.
     * @sample AmazonEC2.CreateTransitGatewayRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateTransitGatewayRoute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateTransitGatewayRouteResult createTransitGatewayRoute(CreateTransitGatewayRouteRequest request) {
        request = beforeClientExecution(request);
        return executeCreateTransitGatewayRoute(request);
    }

    @SdkInternalApi
    final CreateTransitGatewayRouteResult executeCreateTransitGatewayRoute(CreateTransitGatewayRouteRequest createTransitGatewayRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(createTransitGatewayRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTransitGatewayRouteRequest> request = null;
        Response<CreateTransitGatewayRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTransitGatewayRouteRequestMarshaller().marshall(super.beforeMarshalling(createTransitGatewayRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTransitGatewayRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateTransitGatewayRouteResult> responseHandler = new StaxResponseHandler<CreateTransitGatewayRouteResult>(
                    new CreateTransitGatewayRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a route table for the specified transit gateway.
     * </p>
     * 
     * @param createTransitGatewayRouteTableRequest
     * @return Result of the CreateTransitGatewayRouteTable operation returned by the service.
     * @sample AmazonEC2.CreateTransitGatewayRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateTransitGatewayRouteTable"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateTransitGatewayRouteTableResult createTransitGatewayRouteTable(CreateTransitGatewayRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeCreateTransitGatewayRouteTable(request);
    }

    @SdkInternalApi
    final CreateTransitGatewayRouteTableResult executeCreateTransitGatewayRouteTable(CreateTransitGatewayRouteTableRequest createTransitGatewayRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(createTransitGatewayRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTransitGatewayRouteTableRequest> request = null;
        Response<CreateTransitGatewayRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTransitGatewayRouteTableRequestMarshaller().marshall(super.beforeMarshalling(createTransitGatewayRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTransitGatewayRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateTransitGatewayRouteTableResult> responseHandler = new StaxResponseHandler<CreateTransitGatewayRouteTableResult>(
                    new CreateTransitGatewayRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Attaches the specified VPC to the specified transit gateway.
     * </p>
     * <p>
     * If you attach a VPC with a CIDR range that overlaps the CIDR range of a VPC that is already attached, the new VPC
     * CIDR range is not propagated to the default propagation route table.
     * </p>
     * <p>
     * To send VPC traffic to an attached transit gateway, add a route to the VPC route table using <a>CreateRoute</a>.
     * </p>
     * 
     * @param createTransitGatewayVpcAttachmentRequest
     * @return Result of the CreateTransitGatewayVpcAttachment operation returned by the service.
     * @sample AmazonEC2.CreateTransitGatewayVpcAttachment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateTransitGatewayVpcAttachment"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateTransitGatewayVpcAttachmentResult createTransitGatewayVpcAttachment(CreateTransitGatewayVpcAttachmentRequest request) {
        request = beforeClientExecution(request);
        return executeCreateTransitGatewayVpcAttachment(request);
    }

    @SdkInternalApi
    final CreateTransitGatewayVpcAttachmentResult executeCreateTransitGatewayVpcAttachment(
            CreateTransitGatewayVpcAttachmentRequest createTransitGatewayVpcAttachmentRequest) {

        ExecutionContext executionContext = createExecutionContext(createTransitGatewayVpcAttachmentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTransitGatewayVpcAttachmentRequest> request = null;
        Response<CreateTransitGatewayVpcAttachmentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTransitGatewayVpcAttachmentRequestMarshaller().marshall(super.beforeMarshalling(createTransitGatewayVpcAttachmentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTransitGatewayVpcAttachment");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateTransitGatewayVpcAttachmentResult> responseHandler = new StaxResponseHandler<CreateTransitGatewayVpcAttachmentResult>(
                    new CreateTransitGatewayVpcAttachmentResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates an EBS volume that can be attached to an instance in the same Availability Zone. The volume is created in
     * the regional endpoint that you send the HTTP request to. For more information see <a
     * href="http://docs.aws.amazon.com/general/latest/gr/rande.html">Regions and Endpoints</a>.
     * </p>
     * <p>
     * You can create a new empty volume or restore a volume from an EBS snapshot. Any AWS Marketplace product codes
     * from the snapshot are propagated to the volume.
     * </p>
     * <p>
     * You can create encrypted volumes with the <code>Encrypted</code> parameter. Encrypted volumes may only be
     * attached to instances that support Amazon EBS encryption. Volumes that are created from encrypted snapshots are
     * also automatically encrypted. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html">Amazon EBS Encryption</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * You can tag your volumes during creation. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Amazon EC2 Resources</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-creating-volume.html">Creating an Amazon EBS
     * Volume</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createVolumeRequest
     *        Contains the parameters for CreateVolume.
     * @return Result of the CreateVolume operation returned by the service.
     * @sample AmazonEC2.CreateVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateVolumeResult createVolume(CreateVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVolume(request);
    }

    @SdkInternalApi
    final CreateVolumeResult executeCreateVolume(CreateVolumeRequest createVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(createVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVolumeRequest> request = null;
        Response<CreateVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVolumeRequestMarshaller().marshall(super.beforeMarshalling(createVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVolumeResult> responseHandler = new StaxResponseHandler<CreateVolumeResult>(new CreateVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a VPC with the specified IPv4 CIDR block. The smallest VPC you can create uses a /28 netmask (16 IPv4
     * addresses), and the largest uses a /16 netmask (65,536 IPv4 addresses). For more information about how large to
     * make your VPC, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Subnets.html">Your VPC and
     * Subnets</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * You can optionally request an Amazon-provided IPv6 CIDR block for the VPC. The IPv6 CIDR block uses a /56 prefix
     * length, and is allocated from Amazon's pool of IPv6 addresses. You cannot choose the IPv6 range for your VPC.
     * </p>
     * <p>
     * By default, each instance you launch in the VPC has the default DHCP options, which include only a default DNS
     * server that we provide (AmazonProvidedDNS). For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_DHCP_Options.html">DHCP Options Sets</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * You can specify the instance tenancy value for the VPC when you create it. You can't change this value for the
     * VPC after you create it. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-instance.html">Dedicated Instances</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param createVpcRequest
     * @return Result of the CreateVpc operation returned by the service.
     * @sample AmazonEC2.CreateVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateVpcResult createVpc(CreateVpcRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpc(request);
    }

    @SdkInternalApi
    final CreateVpcResult executeCreateVpc(CreateVpcRequest createVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpcRequest> request = null;
        Response<CreateVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpcRequestMarshaller().marshall(super.beforeMarshalling(createVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpcResult> responseHandler = new StaxResponseHandler<CreateVpcResult>(new CreateVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a VPC endpoint for a specified service. An endpoint enables you to create a private connection between
     * your VPC and the service. The service may be provided by AWS, an AWS Marketplace partner, or another AWS account.
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/vpc-endpoints.html">VPC
     * Endpoints</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * A <code>gateway</code> endpoint serves as a target for a route in your route table for traffic destined for the
     * AWS service. You can specify an endpoint policy to attach to the endpoint that will control access to the service
     * from your VPC. You can also specify the VPC route tables that use the endpoint.
     * </p>
     * <p>
     * An <code>interface</code> endpoint is a network interface in your subnet that serves as an endpoint for
     * communicating with the specified service. You can specify the subnets in which to create an endpoint, and the
     * security groups to associate with the endpoint network interface.
     * </p>
     * <p>
     * Use <a>DescribeVpcEndpointServices</a> to get a list of supported services.
     * </p>
     * 
     * @param createVpcEndpointRequest
     *        Contains the parameters for CreateVpcEndpoint.
     * @return Result of the CreateVpcEndpoint operation returned by the service.
     * @sample AmazonEC2.CreateVpcEndpoint
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpcEndpoint" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateVpcEndpointResult createVpcEndpoint(CreateVpcEndpointRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpcEndpoint(request);
    }

    @SdkInternalApi
    final CreateVpcEndpointResult executeCreateVpcEndpoint(CreateVpcEndpointRequest createVpcEndpointRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpcEndpointRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpcEndpointRequest> request = null;
        Response<CreateVpcEndpointResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpcEndpointRequestMarshaller().marshall(super.beforeMarshalling(createVpcEndpointRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpcEndpoint");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpcEndpointResult> responseHandler = new StaxResponseHandler<CreateVpcEndpointResult>(
                    new CreateVpcEndpointResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a connection notification for a specified VPC endpoint or VPC endpoint service. A connection notification
     * notifies you of specific endpoint events. You must create an SNS topic to receive notifications. For more
     * information, see <a href="http://docs.aws.amazon.com/sns/latest/dg/CreateTopic.html">Create a Topic</a> in the
     * <i>Amazon Simple Notification Service Developer Guide</i>.
     * </p>
     * <p>
     * You can create a connection notification for interface endpoints only.
     * </p>
     * 
     * @param createVpcEndpointConnectionNotificationRequest
     * @return Result of the CreateVpcEndpointConnectionNotification operation returned by the service.
     * @sample AmazonEC2.CreateVpcEndpointConnectionNotification
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpcEndpointConnectionNotification"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateVpcEndpointConnectionNotificationResult createVpcEndpointConnectionNotification(CreateVpcEndpointConnectionNotificationRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpcEndpointConnectionNotification(request);
    }

    @SdkInternalApi
    final CreateVpcEndpointConnectionNotificationResult executeCreateVpcEndpointConnectionNotification(
            CreateVpcEndpointConnectionNotificationRequest createVpcEndpointConnectionNotificationRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpcEndpointConnectionNotificationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpcEndpointConnectionNotificationRequest> request = null;
        Response<CreateVpcEndpointConnectionNotificationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpcEndpointConnectionNotificationRequestMarshaller().marshall(super
                        .beforeMarshalling(createVpcEndpointConnectionNotificationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpcEndpointConnectionNotification");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpcEndpointConnectionNotificationResult> responseHandler = new StaxResponseHandler<CreateVpcEndpointConnectionNotificationResult>(
                    new CreateVpcEndpointConnectionNotificationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a VPC endpoint service configuration to which service consumers (AWS accounts, IAM users, and IAM roles)
     * can connect. Service consumers can create an interface VPC endpoint to connect to your service.
     * </p>
     * <p>
     * To create an endpoint service configuration, you must first create a Network Load Balancer for your service. For
     * more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/endpoint-service.html">VPC
     * Endpoint Services</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createVpcEndpointServiceConfigurationRequest
     * @return Result of the CreateVpcEndpointServiceConfiguration operation returned by the service.
     * @sample AmazonEC2.CreateVpcEndpointServiceConfiguration
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpcEndpointServiceConfiguration"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CreateVpcEndpointServiceConfigurationResult createVpcEndpointServiceConfiguration(CreateVpcEndpointServiceConfigurationRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpcEndpointServiceConfiguration(request);
    }

    @SdkInternalApi
    final CreateVpcEndpointServiceConfigurationResult executeCreateVpcEndpointServiceConfiguration(
            CreateVpcEndpointServiceConfigurationRequest createVpcEndpointServiceConfigurationRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpcEndpointServiceConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpcEndpointServiceConfigurationRequest> request = null;
        Response<CreateVpcEndpointServiceConfigurationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpcEndpointServiceConfigurationRequestMarshaller().marshall(super
                        .beforeMarshalling(createVpcEndpointServiceConfigurationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpcEndpointServiceConfiguration");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpcEndpointServiceConfigurationResult> responseHandler = new StaxResponseHandler<CreateVpcEndpointServiceConfigurationResult>(
                    new CreateVpcEndpointServiceConfigurationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Requests a VPC peering connection between two VPCs: a requester VPC that you own and an accepter VPC with which
     * to create the connection. The accepter VPC can belong to another AWS account and can be in a different Region to
     * the requester VPC. The requester VPC and accepter VPC cannot have overlapping CIDR blocks.
     * </p>
     * <note>
     * <p>
     * Limitations and rules apply to a VPC peering connection. For more information, see the <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/PeeringGuide/vpc-peering-basics.html#vpc-peering-limitations"
     * >limitations</a> section in the <i>VPC Peering Guide</i>.
     * </p>
     * </note>
     * <p>
     * The owner of the accepter VPC must accept the peering request to activate the peering connection. The VPC peering
     * connection request expires after 7 days, after which it cannot be accepted or rejected.
     * </p>
     * <p>
     * If you create a VPC peering connection request between VPCs with overlapping CIDR blocks, the VPC peering
     * connection has a status of <code>failed</code>.
     * </p>
     * 
     * @param createVpcPeeringConnectionRequest
     * @return Result of the CreateVpcPeeringConnection operation returned by the service.
     * @sample AmazonEC2.CreateVpcPeeringConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpcPeeringConnection" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateVpcPeeringConnectionResult createVpcPeeringConnection(CreateVpcPeeringConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpcPeeringConnection(request);
    }

    @SdkInternalApi
    final CreateVpcPeeringConnectionResult executeCreateVpcPeeringConnection(CreateVpcPeeringConnectionRequest createVpcPeeringConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpcPeeringConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpcPeeringConnectionRequest> request = null;
        Response<CreateVpcPeeringConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpcPeeringConnectionRequestMarshaller().marshall(super.beforeMarshalling(createVpcPeeringConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpcPeeringConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpcPeeringConnectionResult> responseHandler = new StaxResponseHandler<CreateVpcPeeringConnectionResult>(
                    new CreateVpcPeeringConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public CreateVpcPeeringConnectionResult createVpcPeeringConnection() {
        return createVpcPeeringConnection(new CreateVpcPeeringConnectionRequest());
    }

    /**
     * <p>
     * Creates a VPN connection between an existing virtual private gateway and a VPN customer gateway. The only
     * supported connection type is <code>ipsec.1</code>.
     * </p>
     * <p>
     * The response includes information that you need to give to your network administrator to configure your customer
     * gateway.
     * </p>
     * <important>
     * <p>
     * We strongly recommend that you use HTTPS when calling this operation because the response contains sensitive
     * cryptographic information for configuring your customer gateway.
     * </p>
     * </important>
     * <p>
     * If you decide to shut down your VPN connection for any reason and later create a new VPN connection, you must
     * reconfigure your customer gateway with the new information returned from this call.
     * </p>
     * <p>
     * This is an idempotent operation. If you perform the operation more than once, Amazon EC2 doesn't return an error.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS
     * Managed VPN Connections</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createVpnConnectionRequest
     *        Contains the parameters for CreateVpnConnection.
     * @return Result of the CreateVpnConnection operation returned by the service.
     * @sample AmazonEC2.CreateVpnConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpnConnection" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateVpnConnectionResult createVpnConnection(CreateVpnConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpnConnection(request);
    }

    @SdkInternalApi
    final CreateVpnConnectionResult executeCreateVpnConnection(CreateVpnConnectionRequest createVpnConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpnConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpnConnectionRequest> request = null;
        Response<CreateVpnConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpnConnectionRequestMarshaller().marshall(super.beforeMarshalling(createVpnConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpnConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpnConnectionResult> responseHandler = new StaxResponseHandler<CreateVpnConnectionResult>(
                    new CreateVpnConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a static route associated with a VPN connection between an existing virtual private gateway and a VPN
     * customer gateway. The static route allows traffic to be routed from the virtual private gateway to the VPN
     * customer gateway.
     * </p>
     * <p>
     * For more information about VPN connections, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createVpnConnectionRouteRequest
     *        Contains the parameters for CreateVpnConnectionRoute.
     * @return Result of the CreateVpnConnectionRoute operation returned by the service.
     * @sample AmazonEC2.CreateVpnConnectionRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpnConnectionRoute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CreateVpnConnectionRouteResult createVpnConnectionRoute(CreateVpnConnectionRouteRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpnConnectionRoute(request);
    }

    @SdkInternalApi
    final CreateVpnConnectionRouteResult executeCreateVpnConnectionRoute(CreateVpnConnectionRouteRequest createVpnConnectionRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpnConnectionRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpnConnectionRouteRequest> request = null;
        Response<CreateVpnConnectionRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpnConnectionRouteRequestMarshaller().marshall(super.beforeMarshalling(createVpnConnectionRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpnConnectionRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpnConnectionRouteResult> responseHandler = new StaxResponseHandler<CreateVpnConnectionRouteResult>(
                    new CreateVpnConnectionRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a virtual private gateway. A virtual private gateway is the endpoint on the VPC side of your VPN
     * connection. You can create a virtual private gateway before creating the VPC itself.
     * </p>
     * <p>
     * For more information about virtual private gateways, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param createVpnGatewayRequest
     *        Contains the parameters for CreateVpnGateway.
     * @return Result of the CreateVpnGateway operation returned by the service.
     * @sample AmazonEC2.CreateVpnGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/CreateVpnGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public CreateVpnGatewayResult createVpnGateway(CreateVpnGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeCreateVpnGateway(request);
    }

    @SdkInternalApi
    final CreateVpnGatewayResult executeCreateVpnGateway(CreateVpnGatewayRequest createVpnGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(createVpnGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVpnGatewayRequest> request = null;
        Response<CreateVpnGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVpnGatewayRequestMarshaller().marshall(super.beforeMarshalling(createVpnGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVpnGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<CreateVpnGatewayResult> responseHandler = new StaxResponseHandler<CreateVpnGatewayResult>(
                    new CreateVpnGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified customer gateway. You must delete the VPN connection before you can delete the customer
     * gateway.
     * </p>
     * 
     * @param deleteCustomerGatewayRequest
     *        Contains the parameters for DeleteCustomerGateway.
     * @return Result of the DeleteCustomerGateway operation returned by the service.
     * @sample AmazonEC2.DeleteCustomerGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteCustomerGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteCustomerGatewayResult deleteCustomerGateway(DeleteCustomerGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteCustomerGateway(request);
    }

    @SdkInternalApi
    final DeleteCustomerGatewayResult executeDeleteCustomerGateway(DeleteCustomerGatewayRequest deleteCustomerGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteCustomerGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteCustomerGatewayRequest> request = null;
        Response<DeleteCustomerGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteCustomerGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteCustomerGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteCustomerGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteCustomerGatewayResult> responseHandler = new StaxResponseHandler<DeleteCustomerGatewayResult>(
                    new DeleteCustomerGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified set of DHCP options. You must disassociate the set of DHCP options before you can delete
     * it. You can disassociate the set of DHCP options by associating either a new set of options or the default set of
     * options with the VPC.
     * </p>
     * 
     * @param deleteDhcpOptionsRequest
     * @return Result of the DeleteDhcpOptions operation returned by the service.
     * @sample AmazonEC2.DeleteDhcpOptions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteDhcpOptions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteDhcpOptionsResult deleteDhcpOptions(DeleteDhcpOptionsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteDhcpOptions(request);
    }

    @SdkInternalApi
    final DeleteDhcpOptionsResult executeDeleteDhcpOptions(DeleteDhcpOptionsRequest deleteDhcpOptionsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteDhcpOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteDhcpOptionsRequest> request = null;
        Response<DeleteDhcpOptionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteDhcpOptionsRequestMarshaller().marshall(super.beforeMarshalling(deleteDhcpOptionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteDhcpOptions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteDhcpOptionsResult> responseHandler = new StaxResponseHandler<DeleteDhcpOptionsResult>(
                    new DeleteDhcpOptionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes an egress-only internet gateway.
     * </p>
     * 
     * @param deleteEgressOnlyInternetGatewayRequest
     * @return Result of the DeleteEgressOnlyInternetGateway operation returned by the service.
     * @sample AmazonEC2.DeleteEgressOnlyInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteEgressOnlyInternetGateway"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteEgressOnlyInternetGatewayResult deleteEgressOnlyInternetGateway(DeleteEgressOnlyInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteEgressOnlyInternetGateway(request);
    }

    @SdkInternalApi
    final DeleteEgressOnlyInternetGatewayResult executeDeleteEgressOnlyInternetGateway(
            DeleteEgressOnlyInternetGatewayRequest deleteEgressOnlyInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteEgressOnlyInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteEgressOnlyInternetGatewayRequest> request = null;
        Response<DeleteEgressOnlyInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteEgressOnlyInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteEgressOnlyInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteEgressOnlyInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteEgressOnlyInternetGatewayResult> responseHandler = new StaxResponseHandler<DeleteEgressOnlyInternetGatewayResult>(
                    new DeleteEgressOnlyInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified EC2 Fleet.
     * </p>
     * <p>
     * After you delete an EC2 Fleet, it launches no new instances. You must specify whether an EC2 Fleet should also
     * terminate its instances. If you terminate the instances, the EC2 Fleet enters the
     * <code>deleted_terminating</code> state. Otherwise, the EC2 Fleet enters the <code>deleted_running</code> state,
     * and the instances continue to run until they are interrupted or you terminate them manually.
     * </p>
     * 
     * @param deleteFleetsRequest
     * @return Result of the DeleteFleets operation returned by the service.
     * @sample AmazonEC2.DeleteFleets
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteFleets" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteFleetsResult deleteFleets(DeleteFleetsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteFleets(request);
    }

    @SdkInternalApi
    final DeleteFleetsResult executeDeleteFleets(DeleteFleetsRequest deleteFleetsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteFleetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteFleetsRequest> request = null;
        Response<DeleteFleetsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteFleetsRequestMarshaller().marshall(super.beforeMarshalling(deleteFleetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteFleets");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteFleetsResult> responseHandler = new StaxResponseHandler<DeleteFleetsResult>(new DeleteFleetsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes one or more flow logs.
     * </p>
     * 
     * @param deleteFlowLogsRequest
     * @return Result of the DeleteFlowLogs operation returned by the service.
     * @sample AmazonEC2.DeleteFlowLogs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteFlowLogs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteFlowLogsResult deleteFlowLogs(DeleteFlowLogsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteFlowLogs(request);
    }

    @SdkInternalApi
    final DeleteFlowLogsResult executeDeleteFlowLogs(DeleteFlowLogsRequest deleteFlowLogsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteFlowLogsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteFlowLogsRequest> request = null;
        Response<DeleteFlowLogsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteFlowLogsRequestMarshaller().marshall(super.beforeMarshalling(deleteFlowLogsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteFlowLogs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteFlowLogsResult> responseHandler = new StaxResponseHandler<DeleteFlowLogsResult>(
                    new DeleteFlowLogsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified Amazon FPGA Image (AFI).
     * </p>
     * 
     * @param deleteFpgaImageRequest
     * @return Result of the DeleteFpgaImage operation returned by the service.
     * @sample AmazonEC2.DeleteFpgaImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteFpgaImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteFpgaImageResult deleteFpgaImage(DeleteFpgaImageRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteFpgaImage(request);
    }

    @SdkInternalApi
    final DeleteFpgaImageResult executeDeleteFpgaImage(DeleteFpgaImageRequest deleteFpgaImageRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteFpgaImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteFpgaImageRequest> request = null;
        Response<DeleteFpgaImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteFpgaImageRequestMarshaller().marshall(super.beforeMarshalling(deleteFpgaImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteFpgaImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteFpgaImageResult> responseHandler = new StaxResponseHandler<DeleteFpgaImageResult>(
                    new DeleteFpgaImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified internet gateway. You must detach the internet gateway from the VPC before you can delete
     * it.
     * </p>
     * 
     * @param deleteInternetGatewayRequest
     * @return Result of the DeleteInternetGateway operation returned by the service.
     * @sample AmazonEC2.DeleteInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteInternetGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteInternetGatewayResult deleteInternetGateway(DeleteInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteInternetGateway(request);
    }

    @SdkInternalApi
    final DeleteInternetGatewayResult executeDeleteInternetGateway(DeleteInternetGatewayRequest deleteInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteInternetGatewayRequest> request = null;
        Response<DeleteInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteInternetGatewayResult> responseHandler = new StaxResponseHandler<DeleteInternetGatewayResult>(
                    new DeleteInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified key pair, by removing the public key from Amazon EC2.
     * </p>
     * 
     * @param deleteKeyPairRequest
     * @return Result of the DeleteKeyPair operation returned by the service.
     * @sample AmazonEC2.DeleteKeyPair
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteKeyPair" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteKeyPairResult deleteKeyPair(DeleteKeyPairRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteKeyPair(request);
    }

    @SdkInternalApi
    final DeleteKeyPairResult executeDeleteKeyPair(DeleteKeyPairRequest deleteKeyPairRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteKeyPairRequest> request = null;
        Response<DeleteKeyPairResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteKeyPairRequestMarshaller().marshall(super.beforeMarshalling(deleteKeyPairRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteKeyPair");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteKeyPairResult> responseHandler = new StaxResponseHandler<DeleteKeyPairResult>(new DeleteKeyPairResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes a launch template. Deleting a launch template deletes all of its versions.
     * </p>
     * 
     * @param deleteLaunchTemplateRequest
     * @return Result of the DeleteLaunchTemplate operation returned by the service.
     * @sample AmazonEC2.DeleteLaunchTemplate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteLaunchTemplate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteLaunchTemplateResult deleteLaunchTemplate(DeleteLaunchTemplateRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteLaunchTemplate(request);
    }

    @SdkInternalApi
    final DeleteLaunchTemplateResult executeDeleteLaunchTemplate(DeleteLaunchTemplateRequest deleteLaunchTemplateRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteLaunchTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteLaunchTemplateRequest> request = null;
        Response<DeleteLaunchTemplateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteLaunchTemplateRequestMarshaller().marshall(super.beforeMarshalling(deleteLaunchTemplateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteLaunchTemplate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteLaunchTemplateResult> responseHandler = new StaxResponseHandler<DeleteLaunchTemplateResult>(
                    new DeleteLaunchTemplateResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes one or more versions of a launch template. You cannot delete the default version of a launch template;
     * you must first assign a different version as the default. If the default version is the only version for the
     * launch template, you must delete the entire launch template using <a>DeleteLaunchTemplate</a>.
     * </p>
     * 
     * @param deleteLaunchTemplateVersionsRequest
     * @return Result of the DeleteLaunchTemplateVersions operation returned by the service.
     * @sample AmazonEC2.DeleteLaunchTemplateVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteLaunchTemplateVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteLaunchTemplateVersionsResult deleteLaunchTemplateVersions(DeleteLaunchTemplateVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteLaunchTemplateVersions(request);
    }

    @SdkInternalApi
    final DeleteLaunchTemplateVersionsResult executeDeleteLaunchTemplateVersions(DeleteLaunchTemplateVersionsRequest deleteLaunchTemplateVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteLaunchTemplateVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteLaunchTemplateVersionsRequest> request = null;
        Response<DeleteLaunchTemplateVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteLaunchTemplateVersionsRequestMarshaller().marshall(super.beforeMarshalling(deleteLaunchTemplateVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteLaunchTemplateVersions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteLaunchTemplateVersionsResult> responseHandler = new StaxResponseHandler<DeleteLaunchTemplateVersionsResult>(
                    new DeleteLaunchTemplateVersionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified NAT gateway. Deleting a NAT gateway disassociates its Elastic IP address, but does not
     * release the address from your account. Deleting a NAT gateway does not delete any NAT gateway routes in your
     * route tables.
     * </p>
     * 
     * @param deleteNatGatewayRequest
     * @return Result of the DeleteNatGateway operation returned by the service.
     * @sample AmazonEC2.DeleteNatGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteNatGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteNatGatewayResult deleteNatGateway(DeleteNatGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteNatGateway(request);
    }

    @SdkInternalApi
    final DeleteNatGatewayResult executeDeleteNatGateway(DeleteNatGatewayRequest deleteNatGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteNatGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteNatGatewayRequest> request = null;
        Response<DeleteNatGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteNatGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteNatGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteNatGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteNatGatewayResult> responseHandler = new StaxResponseHandler<DeleteNatGatewayResult>(
                    new DeleteNatGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified network ACL. You can't delete the ACL if it's associated with any subnets. You can't delete
     * the default network ACL.
     * </p>
     * 
     * @param deleteNetworkAclRequest
     * @return Result of the DeleteNetworkAcl operation returned by the service.
     * @sample AmazonEC2.DeleteNetworkAcl
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteNetworkAcl" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteNetworkAclResult deleteNetworkAcl(DeleteNetworkAclRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteNetworkAcl(request);
    }

    @SdkInternalApi
    final DeleteNetworkAclResult executeDeleteNetworkAcl(DeleteNetworkAclRequest deleteNetworkAclRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteNetworkAclRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteNetworkAclRequest> request = null;
        Response<DeleteNetworkAclResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteNetworkAclRequestMarshaller().marshall(super.beforeMarshalling(deleteNetworkAclRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteNetworkAcl");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteNetworkAclResult> responseHandler = new StaxResponseHandler<DeleteNetworkAclResult>(
                    new DeleteNetworkAclResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified ingress or egress entry (rule) from the specified network ACL.
     * </p>
     * 
     * @param deleteNetworkAclEntryRequest
     * @return Result of the DeleteNetworkAclEntry operation returned by the service.
     * @sample AmazonEC2.DeleteNetworkAclEntry
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteNetworkAclEntry" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteNetworkAclEntryResult deleteNetworkAclEntry(DeleteNetworkAclEntryRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteNetworkAclEntry(request);
    }

    @SdkInternalApi
    final DeleteNetworkAclEntryResult executeDeleteNetworkAclEntry(DeleteNetworkAclEntryRequest deleteNetworkAclEntryRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteNetworkAclEntryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteNetworkAclEntryRequest> request = null;
        Response<DeleteNetworkAclEntryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteNetworkAclEntryRequestMarshaller().marshall(super.beforeMarshalling(deleteNetworkAclEntryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteNetworkAclEntry");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteNetworkAclEntryResult> responseHandler = new StaxResponseHandler<DeleteNetworkAclEntryResult>(
                    new DeleteNetworkAclEntryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified network interface. You must detach the network interface before you can delete it.
     * </p>
     * 
     * @param deleteNetworkInterfaceRequest
     *        Contains the parameters for DeleteNetworkInterface.
     * @return Result of the DeleteNetworkInterface operation returned by the service.
     * @sample AmazonEC2.DeleteNetworkInterface
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteNetworkInterface" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteNetworkInterfaceResult deleteNetworkInterface(DeleteNetworkInterfaceRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteNetworkInterface(request);
    }

    @SdkInternalApi
    final DeleteNetworkInterfaceResult executeDeleteNetworkInterface(DeleteNetworkInterfaceRequest deleteNetworkInterfaceRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteNetworkInterfaceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteNetworkInterfaceRequest> request = null;
        Response<DeleteNetworkInterfaceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteNetworkInterfaceRequestMarshaller().marshall(super.beforeMarshalling(deleteNetworkInterfaceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteNetworkInterface");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteNetworkInterfaceResult> responseHandler = new StaxResponseHandler<DeleteNetworkInterfaceResult>(
                    new DeleteNetworkInterfaceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes a permission for a network interface. By default, you cannot delete the permission if the account for
     * which you're removing the permission has attached the network interface to an instance. However, you can force
     * delete the permission, regardless of any attachment.
     * </p>
     * 
     * @param deleteNetworkInterfacePermissionRequest
     *        Contains the parameters for DeleteNetworkInterfacePermission.
     * @return Result of the DeleteNetworkInterfacePermission operation returned by the service.
     * @sample AmazonEC2.DeleteNetworkInterfacePermission
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteNetworkInterfacePermission"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteNetworkInterfacePermissionResult deleteNetworkInterfacePermission(DeleteNetworkInterfacePermissionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteNetworkInterfacePermission(request);
    }

    @SdkInternalApi
    final DeleteNetworkInterfacePermissionResult executeDeleteNetworkInterfacePermission(
            DeleteNetworkInterfacePermissionRequest deleteNetworkInterfacePermissionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteNetworkInterfacePermissionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteNetworkInterfacePermissionRequest> request = null;
        Response<DeleteNetworkInterfacePermissionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteNetworkInterfacePermissionRequestMarshaller().marshall(super.beforeMarshalling(deleteNetworkInterfacePermissionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteNetworkInterfacePermission");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteNetworkInterfacePermissionResult> responseHandler = new StaxResponseHandler<DeleteNetworkInterfacePermissionResult>(
                    new DeleteNetworkInterfacePermissionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified placement group. You must terminate all instances in the placement group before you can
     * delete the placement group. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html">Placement Groups</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param deletePlacementGroupRequest
     *        Contains the parameters for DeletePlacementGroup.
     * @return Result of the DeletePlacementGroup operation returned by the service.
     * @sample AmazonEC2.DeletePlacementGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeletePlacementGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeletePlacementGroupResult deletePlacementGroup(DeletePlacementGroupRequest request) {
        request = beforeClientExecution(request);
        return executeDeletePlacementGroup(request);
    }

    @SdkInternalApi
    final DeletePlacementGroupResult executeDeletePlacementGroup(DeletePlacementGroupRequest deletePlacementGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(deletePlacementGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeletePlacementGroupRequest> request = null;
        Response<DeletePlacementGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeletePlacementGroupRequestMarshaller().marshall(super.beforeMarshalling(deletePlacementGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeletePlacementGroup");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeletePlacementGroupResult> responseHandler = new StaxResponseHandler<DeletePlacementGroupResult>(
                    new DeletePlacementGroupResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified route from the specified route table.
     * </p>
     * 
     * @param deleteRouteRequest
     * @return Result of the DeleteRoute operation returned by the service.
     * @sample AmazonEC2.DeleteRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteRoute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteRouteResult deleteRoute(DeleteRouteRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteRoute(request);
    }

    @SdkInternalApi
    final DeleteRouteResult executeDeleteRoute(DeleteRouteRequest deleteRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteRouteRequest> request = null;
        Response<DeleteRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteRouteRequestMarshaller().marshall(super.beforeMarshalling(deleteRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteRouteResult> responseHandler = new StaxResponseHandler<DeleteRouteResult>(new DeleteRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified route table. You must disassociate the route table from any subnets before you can delete
     * it. You can't delete the main route table.
     * </p>
     * 
     * @param deleteRouteTableRequest
     * @return Result of the DeleteRouteTable operation returned by the service.
     * @sample AmazonEC2.DeleteRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteRouteTable" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteRouteTableResult deleteRouteTable(DeleteRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteRouteTable(request);
    }

    @SdkInternalApi
    final DeleteRouteTableResult executeDeleteRouteTable(DeleteRouteTableRequest deleteRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteRouteTableRequest> request = null;
        Response<DeleteRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteRouteTableRequestMarshaller().marshall(super.beforeMarshalling(deleteRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteRouteTableResult> responseHandler = new StaxResponseHandler<DeleteRouteTableResult>(
                    new DeleteRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes a security group.
     * </p>
     * <p>
     * If you attempt to delete a security group that is associated with an instance, or is referenced by another
     * security group, the operation fails with <code>InvalidGroup.InUse</code> in EC2-Classic or
     * <code>DependencyViolation</code> in EC2-VPC.
     * </p>
     * 
     * @param deleteSecurityGroupRequest
     * @return Result of the DeleteSecurityGroup operation returned by the service.
     * @sample AmazonEC2.DeleteSecurityGroup
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteSecurityGroup" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteSecurityGroupResult deleteSecurityGroup(DeleteSecurityGroupRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteSecurityGroup(request);
    }

    @SdkInternalApi
    final DeleteSecurityGroupResult executeDeleteSecurityGroup(DeleteSecurityGroupRequest deleteSecurityGroupRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSecurityGroupRequest> request = null;
        Response<DeleteSecurityGroupResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSecurityGroupRequestMarshaller().marshall(super.beforeMarshalling(deleteSecurityGroupRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSecurityGroup");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteSecurityGroupResult> responseHandler = new StaxResponseHandler<DeleteSecurityGroupResult>(
                    new DeleteSecurityGroupResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified snapshot.
     * </p>
     * <p>
     * When you make periodic snapshots of a volume, the snapshots are incremental, and only the blocks on the device
     * that have changed since your last snapshot are saved in the new snapshot. When you delete a snapshot, only the
     * data not needed for any other snapshot is removed. So regardless of which prior snapshots have been deleted, all
     * active snapshots will have access to all the information needed to restore the volume.
     * </p>
     * <p>
     * You cannot delete a snapshot of the root device of an EBS volume used by a registered AMI. You must first
     * de-register the AMI before you can delete the snapshot.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-deleting-snapshot.html">Deleting an Amazon EBS
     * Snapshot</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param deleteSnapshotRequest
     *        Contains the parameters for DeleteSnapshot.
     * @return Result of the DeleteSnapshot operation returned by the service.
     * @sample AmazonEC2.DeleteSnapshot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteSnapshot" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteSnapshot(request);
    }

    @SdkInternalApi
    final DeleteSnapshotResult executeDeleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSnapshotRequest> request = null;
        Response<DeleteSnapshotResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSnapshotRequestMarshaller().marshall(super.beforeMarshalling(deleteSnapshotRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSnapshot");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteSnapshotResult> responseHandler = new StaxResponseHandler<DeleteSnapshotResult>(
                    new DeleteSnapshotResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the data feed for Spot Instances.
     * </p>
     * 
     * @param deleteSpotDatafeedSubscriptionRequest
     *        Contains the parameters for DeleteSpotDatafeedSubscription.
     * @return Result of the DeleteSpotDatafeedSubscription operation returned by the service.
     * @sample AmazonEC2.DeleteSpotDatafeedSubscription
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteSpotDatafeedSubscription"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteSpotDatafeedSubscriptionResult deleteSpotDatafeedSubscription(DeleteSpotDatafeedSubscriptionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteSpotDatafeedSubscription(request);
    }

    @SdkInternalApi
    final DeleteSpotDatafeedSubscriptionResult executeDeleteSpotDatafeedSubscription(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSpotDatafeedSubscriptionRequest> request = null;
        Response<DeleteSpotDatafeedSubscriptionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSpotDatafeedSubscriptionRequestMarshaller().marshall(super.beforeMarshalling(deleteSpotDatafeedSubscriptionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSpotDatafeedSubscription");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteSpotDatafeedSubscriptionResult> responseHandler = new StaxResponseHandler<DeleteSpotDatafeedSubscriptionResult>(
                    new DeleteSpotDatafeedSubscriptionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DeleteSpotDatafeedSubscriptionResult deleteSpotDatafeedSubscription() {
        return deleteSpotDatafeedSubscription(new DeleteSpotDatafeedSubscriptionRequest());
    }

    /**
     * <p>
     * Deletes the specified subnet. You must terminate all running instances in the subnet before you can delete the
     * subnet.
     * </p>
     * 
     * @param deleteSubnetRequest
     * @return Result of the DeleteSubnet operation returned by the service.
     * @sample AmazonEC2.DeleteSubnet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteSubnet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteSubnetResult deleteSubnet(DeleteSubnetRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteSubnet(request);
    }

    @SdkInternalApi
    final DeleteSubnetResult executeDeleteSubnet(DeleteSubnetRequest deleteSubnetRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteSubnetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteSubnetRequest> request = null;
        Response<DeleteSubnetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteSubnetRequestMarshaller().marshall(super.beforeMarshalling(deleteSubnetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSubnet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteSubnetResult> responseHandler = new StaxResponseHandler<DeleteSubnetResult>(new DeleteSubnetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified set of tags from the specified set of resources.
     * </p>
     * <p>
     * To list the current tags, use <a>DescribeTags</a>. For more information about tags, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Resources</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param deleteTagsRequest
     * @return Result of the DeleteTags operation returned by the service.
     * @sample AmazonEC2.DeleteTags
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteTags" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteTagsResult deleteTags(DeleteTagsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteTags(request);
    }

    @SdkInternalApi
    final DeleteTagsResult executeDeleteTags(DeleteTagsRequest deleteTagsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTagsRequest> request = null;
        Response<DeleteTagsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTagsRequestMarshaller().marshall(super.beforeMarshalling(deleteTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTags");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteTagsResult> responseHandler = new StaxResponseHandler<DeleteTagsResult>(new DeleteTagsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified transit gateway.
     * </p>
     * 
     * @param deleteTransitGatewayRequest
     * @return Result of the DeleteTransitGateway operation returned by the service.
     * @sample AmazonEC2.DeleteTransitGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteTransitGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteTransitGatewayResult deleteTransitGateway(DeleteTransitGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteTransitGateway(request);
    }

    @SdkInternalApi
    final DeleteTransitGatewayResult executeDeleteTransitGateway(DeleteTransitGatewayRequest deleteTransitGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteTransitGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTransitGatewayRequest> request = null;
        Response<DeleteTransitGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTransitGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteTransitGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTransitGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteTransitGatewayResult> responseHandler = new StaxResponseHandler<DeleteTransitGatewayResult>(
                    new DeleteTransitGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified route from the specified transit gateway route table.
     * </p>
     * 
     * @param deleteTransitGatewayRouteRequest
     * @return Result of the DeleteTransitGatewayRoute operation returned by the service.
     * @sample AmazonEC2.DeleteTransitGatewayRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteTransitGatewayRoute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DeleteTransitGatewayRouteResult deleteTransitGatewayRoute(DeleteTransitGatewayRouteRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteTransitGatewayRoute(request);
    }

    @SdkInternalApi
    final DeleteTransitGatewayRouteResult executeDeleteTransitGatewayRoute(DeleteTransitGatewayRouteRequest deleteTransitGatewayRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteTransitGatewayRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTransitGatewayRouteRequest> request = null;
        Response<DeleteTransitGatewayRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTransitGatewayRouteRequestMarshaller().marshall(super.beforeMarshalling(deleteTransitGatewayRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTransitGatewayRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteTransitGatewayRouteResult> responseHandler = new StaxResponseHandler<DeleteTransitGatewayRouteResult>(
                    new DeleteTransitGatewayRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified transit gateway route table. You must disassociate the route table from any transit gateway
     * route tables before you can delete it.
     * </p>
     * 
     * @param deleteTransitGatewayRouteTableRequest
     * @return Result of the DeleteTransitGatewayRouteTable operation returned by the service.
     * @sample AmazonEC2.DeleteTransitGatewayRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteTransitGatewayRouteTable"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteTransitGatewayRouteTableResult deleteTransitGatewayRouteTable(DeleteTransitGatewayRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteTransitGatewayRouteTable(request);
    }

    @SdkInternalApi
    final DeleteTransitGatewayRouteTableResult executeDeleteTransitGatewayRouteTable(DeleteTransitGatewayRouteTableRequest deleteTransitGatewayRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteTransitGatewayRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTransitGatewayRouteTableRequest> request = null;
        Response<DeleteTransitGatewayRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTransitGatewayRouteTableRequestMarshaller().marshall(super.beforeMarshalling(deleteTransitGatewayRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTransitGatewayRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteTransitGatewayRouteTableResult> responseHandler = new StaxResponseHandler<DeleteTransitGatewayRouteTableResult>(
                    new DeleteTransitGatewayRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified VPC attachment.
     * </p>
     * 
     * @param deleteTransitGatewayVpcAttachmentRequest
     * @return Result of the DeleteTransitGatewayVpcAttachment operation returned by the service.
     * @sample AmazonEC2.DeleteTransitGatewayVpcAttachment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteTransitGatewayVpcAttachment"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteTransitGatewayVpcAttachmentResult deleteTransitGatewayVpcAttachment(DeleteTransitGatewayVpcAttachmentRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteTransitGatewayVpcAttachment(request);
    }

    @SdkInternalApi
    final DeleteTransitGatewayVpcAttachmentResult executeDeleteTransitGatewayVpcAttachment(
            DeleteTransitGatewayVpcAttachmentRequest deleteTransitGatewayVpcAttachmentRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteTransitGatewayVpcAttachmentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTransitGatewayVpcAttachmentRequest> request = null;
        Response<DeleteTransitGatewayVpcAttachmentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTransitGatewayVpcAttachmentRequestMarshaller().marshall(super.beforeMarshalling(deleteTransitGatewayVpcAttachmentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTransitGatewayVpcAttachment");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteTransitGatewayVpcAttachmentResult> responseHandler = new StaxResponseHandler<DeleteTransitGatewayVpcAttachmentResult>(
                    new DeleteTransitGatewayVpcAttachmentResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified EBS volume. The volume must be in the <code>available</code> state (not attached to an
     * instance).
     * </p>
     * <p>
     * The volume can remain in the <code>deleting</code> state for several minutes.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-deleting-volume.html">Deleting an Amazon EBS
     * Volume</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param deleteVolumeRequest
     *        Contains the parameters for DeleteVolume.
     * @return Result of the DeleteVolume operation returned by the service.
     * @sample AmazonEC2.DeleteVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteVolumeResult deleteVolume(DeleteVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVolume(request);
    }

    @SdkInternalApi
    final DeleteVolumeResult executeDeleteVolume(DeleteVolumeRequest deleteVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVolumeRequest> request = null;
        Response<DeleteVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVolumeRequestMarshaller().marshall(super.beforeMarshalling(deleteVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVolumeResult> responseHandler = new StaxResponseHandler<DeleteVolumeResult>(new DeleteVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified VPC. You must detach or delete all gateways and resources that are associated with the VPC
     * before you can delete it. For example, you must terminate all instances running in the VPC, delete all security
     * groups associated with the VPC (except the default one), delete all route tables associated with the VPC (except
     * the default one), and so on.
     * </p>
     * 
     * @param deleteVpcRequest
     * @return Result of the DeleteVpc operation returned by the service.
     * @sample AmazonEC2.DeleteVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteVpcResult deleteVpc(DeleteVpcRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpc(request);
    }

    @SdkInternalApi
    final DeleteVpcResult executeDeleteVpc(DeleteVpcRequest deleteVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpcRequest> request = null;
        Response<DeleteVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpcRequestMarshaller().marshall(super.beforeMarshalling(deleteVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpcResult> responseHandler = new StaxResponseHandler<DeleteVpcResult>(new DeleteVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes one or more VPC endpoint connection notifications.
     * </p>
     * 
     * @param deleteVpcEndpointConnectionNotificationsRequest
     * @return Result of the DeleteVpcEndpointConnectionNotifications operation returned by the service.
     * @sample AmazonEC2.DeleteVpcEndpointConnectionNotifications
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpcEndpointConnectionNotifications"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteVpcEndpointConnectionNotificationsResult deleteVpcEndpointConnectionNotifications(DeleteVpcEndpointConnectionNotificationsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpcEndpointConnectionNotifications(request);
    }

    @SdkInternalApi
    final DeleteVpcEndpointConnectionNotificationsResult executeDeleteVpcEndpointConnectionNotifications(
            DeleteVpcEndpointConnectionNotificationsRequest deleteVpcEndpointConnectionNotificationsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpcEndpointConnectionNotificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpcEndpointConnectionNotificationsRequest> request = null;
        Response<DeleteVpcEndpointConnectionNotificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpcEndpointConnectionNotificationsRequestMarshaller().marshall(super
                        .beforeMarshalling(deleteVpcEndpointConnectionNotificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpcEndpointConnectionNotifications");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpcEndpointConnectionNotificationsResult> responseHandler = new StaxResponseHandler<DeleteVpcEndpointConnectionNotificationsResult>(
                    new DeleteVpcEndpointConnectionNotificationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes one or more VPC endpoint service configurations in your account. Before you delete the endpoint service
     * configuration, you must reject any <code>Available</code> or <code>PendingAcceptance</code> interface endpoint
     * connections that are attached to the service.
     * </p>
     * 
     * @param deleteVpcEndpointServiceConfigurationsRequest
     * @return Result of the DeleteVpcEndpointServiceConfigurations operation returned by the service.
     * @sample AmazonEC2.DeleteVpcEndpointServiceConfigurations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpcEndpointServiceConfigurations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DeleteVpcEndpointServiceConfigurationsResult deleteVpcEndpointServiceConfigurations(DeleteVpcEndpointServiceConfigurationsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpcEndpointServiceConfigurations(request);
    }

    @SdkInternalApi
    final DeleteVpcEndpointServiceConfigurationsResult executeDeleteVpcEndpointServiceConfigurations(
            DeleteVpcEndpointServiceConfigurationsRequest deleteVpcEndpointServiceConfigurationsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpcEndpointServiceConfigurationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpcEndpointServiceConfigurationsRequest> request = null;
        Response<DeleteVpcEndpointServiceConfigurationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpcEndpointServiceConfigurationsRequestMarshaller().marshall(super
                        .beforeMarshalling(deleteVpcEndpointServiceConfigurationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpcEndpointServiceConfigurations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpcEndpointServiceConfigurationsResult> responseHandler = new StaxResponseHandler<DeleteVpcEndpointServiceConfigurationsResult>(
                    new DeleteVpcEndpointServiceConfigurationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes one or more specified VPC endpoints. Deleting a gateway endpoint also deletes the endpoint routes in the
     * route tables that were associated with the endpoint. Deleting an interface endpoint deletes the endpoint network
     * interfaces.
     * </p>
     * 
     * @param deleteVpcEndpointsRequest
     *        Contains the parameters for DeleteVpcEndpoints.
     * @return Result of the DeleteVpcEndpoints operation returned by the service.
     * @sample AmazonEC2.DeleteVpcEndpoints
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpcEndpoints" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteVpcEndpointsResult deleteVpcEndpoints(DeleteVpcEndpointsRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpcEndpoints(request);
    }

    @SdkInternalApi
    final DeleteVpcEndpointsResult executeDeleteVpcEndpoints(DeleteVpcEndpointsRequest deleteVpcEndpointsRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpcEndpointsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpcEndpointsRequest> request = null;
        Response<DeleteVpcEndpointsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpcEndpointsRequestMarshaller().marshall(super.beforeMarshalling(deleteVpcEndpointsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpcEndpoints");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpcEndpointsResult> responseHandler = new StaxResponseHandler<DeleteVpcEndpointsResult>(
                    new DeleteVpcEndpointsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes a VPC peering connection. Either the owner of the requester VPC or the owner of the accepter VPC can
     * delete the VPC peering connection if it's in the <code>active</code> state. The owner of the requester VPC can
     * delete a VPC peering connection in the <code>pending-acceptance</code> state. You cannot delete a VPC peering
     * connection that's in the <code>failed</code> state.
     * </p>
     * 
     * @param deleteVpcPeeringConnectionRequest
     * @return Result of the DeleteVpcPeeringConnection operation returned by the service.
     * @sample AmazonEC2.DeleteVpcPeeringConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpcPeeringConnection" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DeleteVpcPeeringConnectionResult deleteVpcPeeringConnection(DeleteVpcPeeringConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpcPeeringConnection(request);
    }

    @SdkInternalApi
    final DeleteVpcPeeringConnectionResult executeDeleteVpcPeeringConnection(DeleteVpcPeeringConnectionRequest deleteVpcPeeringConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpcPeeringConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpcPeeringConnectionRequest> request = null;
        Response<DeleteVpcPeeringConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpcPeeringConnectionRequestMarshaller().marshall(super.beforeMarshalling(deleteVpcPeeringConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpcPeeringConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpcPeeringConnectionResult> responseHandler = new StaxResponseHandler<DeleteVpcPeeringConnectionResult>(
                    new DeleteVpcPeeringConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified VPN connection.
     * </p>
     * <p>
     * If you're deleting the VPC and its associated components, we recommend that you detach the virtual private
     * gateway from the VPC and delete the VPC before deleting the VPN connection. If you believe that the tunnel
     * credentials for your VPN connection have been compromised, you can delete the VPN connection and create a new one
     * that has new keys, without needing to delete the VPC or virtual private gateway. If you create a new VPN
     * connection, you must reconfigure the customer gateway using the new configuration information returned with the
     * new VPN connection ID.
     * </p>
     * 
     * @param deleteVpnConnectionRequest
     *        Contains the parameters for DeleteVpnConnection.
     * @return Result of the DeleteVpnConnection operation returned by the service.
     * @sample AmazonEC2.DeleteVpnConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpnConnection" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteVpnConnectionResult deleteVpnConnection(DeleteVpnConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpnConnection(request);
    }

    @SdkInternalApi
    final DeleteVpnConnectionResult executeDeleteVpnConnection(DeleteVpnConnectionRequest deleteVpnConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpnConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpnConnectionRequest> request = null;
        Response<DeleteVpnConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpnConnectionRequestMarshaller().marshall(super.beforeMarshalling(deleteVpnConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpnConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpnConnectionResult> responseHandler = new StaxResponseHandler<DeleteVpnConnectionResult>(
                    new DeleteVpnConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified static route associated with a VPN connection between an existing virtual private gateway
     * and a VPN customer gateway. The static route allows traffic to be routed from the virtual private gateway to the
     * VPN customer gateway.
     * </p>
     * 
     * @param deleteVpnConnectionRouteRequest
     *        Contains the parameters for DeleteVpnConnectionRoute.
     * @return Result of the DeleteVpnConnectionRoute operation returned by the service.
     * @sample AmazonEC2.DeleteVpnConnectionRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpnConnectionRoute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DeleteVpnConnectionRouteResult deleteVpnConnectionRoute(DeleteVpnConnectionRouteRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpnConnectionRoute(request);
    }

    @SdkInternalApi
    final DeleteVpnConnectionRouteResult executeDeleteVpnConnectionRoute(DeleteVpnConnectionRouteRequest deleteVpnConnectionRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpnConnectionRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpnConnectionRouteRequest> request = null;
        Response<DeleteVpnConnectionRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpnConnectionRouteRequestMarshaller().marshall(super.beforeMarshalling(deleteVpnConnectionRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpnConnectionRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpnConnectionRouteResult> responseHandler = new StaxResponseHandler<DeleteVpnConnectionRouteResult>(
                    new DeleteVpnConnectionRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deletes the specified virtual private gateway. We recommend that before you delete a virtual private gateway, you
     * detach it from the VPC and delete the VPN connection. Note that you don't need to delete the virtual private
     * gateway if you plan to delete and recreate the VPN connection between your VPC and your network.
     * </p>
     * 
     * @param deleteVpnGatewayRequest
     *        Contains the parameters for DeleteVpnGateway.
     * @return Result of the DeleteVpnGateway operation returned by the service.
     * @sample AmazonEC2.DeleteVpnGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeleteVpnGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeleteVpnGatewayResult deleteVpnGateway(DeleteVpnGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDeleteVpnGateway(request);
    }

    @SdkInternalApi
    final DeleteVpnGatewayResult executeDeleteVpnGateway(DeleteVpnGatewayRequest deleteVpnGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(deleteVpnGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVpnGatewayRequest> request = null;
        Response<DeleteVpnGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVpnGatewayRequestMarshaller().marshall(super.beforeMarshalling(deleteVpnGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVpnGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeleteVpnGatewayResult> responseHandler = new StaxResponseHandler<DeleteVpnGatewayResult>(
                    new DeleteVpnGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Releases the specified address range that you provisioned for use with your AWS resources through bring your own
     * IP addresses (BYOIP) and deletes the corresponding address pool.
     * </p>
     * <p>
     * Before you can release an address range, you must stop advertising it using <a>WithdrawByoipCidr</a> and you must
     * not have any IP addresses allocated from its address range.
     * </p>
     * 
     * @param deprovisionByoipCidrRequest
     * @return Result of the DeprovisionByoipCidr operation returned by the service.
     * @sample AmazonEC2.DeprovisionByoipCidr
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeprovisionByoipCidr" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeprovisionByoipCidrResult deprovisionByoipCidr(DeprovisionByoipCidrRequest request) {
        request = beforeClientExecution(request);
        return executeDeprovisionByoipCidr(request);
    }

    @SdkInternalApi
    final DeprovisionByoipCidrResult executeDeprovisionByoipCidr(DeprovisionByoipCidrRequest deprovisionByoipCidrRequest) {

        ExecutionContext executionContext = createExecutionContext(deprovisionByoipCidrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeprovisionByoipCidrRequest> request = null;
        Response<DeprovisionByoipCidrResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeprovisionByoipCidrRequestMarshaller().marshall(super.beforeMarshalling(deprovisionByoipCidrRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeprovisionByoipCidr");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeprovisionByoipCidrResult> responseHandler = new StaxResponseHandler<DeprovisionByoipCidrResult>(
                    new DeprovisionByoipCidrResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deregisters the specified AMI. After you deregister an AMI, it can't be used to launch new instances; however, it
     * doesn't affect any instances that you've already launched from the AMI. You'll continue to incur usage costs for
     * those instances until you terminate them.
     * </p>
     * <p>
     * When you deregister an Amazon EBS-backed AMI, it doesn't affect the snapshot that was created for the root volume
     * of the instance during the AMI creation process. When you deregister an instance store-backed AMI, it doesn't
     * affect the files that you uploaded to Amazon S3 when you created the AMI.
     * </p>
     * 
     * @param deregisterImageRequest
     *        Contains the parameters for DeregisterImage.
     * @return Result of the DeregisterImage operation returned by the service.
     * @sample AmazonEC2.DeregisterImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DeregisterImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DeregisterImageResult deregisterImage(DeregisterImageRequest request) {
        request = beforeClientExecution(request);
        return executeDeregisterImage(request);
    }

    @SdkInternalApi
    final DeregisterImageResult executeDeregisterImage(DeregisterImageRequest deregisterImageRequest) {

        ExecutionContext executionContext = createExecutionContext(deregisterImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeregisterImageRequest> request = null;
        Response<DeregisterImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeregisterImageRequestMarshaller().marshall(super.beforeMarshalling(deregisterImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeregisterImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DeregisterImageResult> responseHandler = new StaxResponseHandler<DeregisterImageResult>(
                    new DeregisterImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes attributes of your AWS account. The following are the supported account attributes:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>supported-platforms</code>: Indicates whether your account can launch instances into EC2-Classic and
     * EC2-VPC, or only into EC2-VPC.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>default-vpc</code>: The ID of the default VPC for your account, or <code>none</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>max-instances</code>: The maximum number of On-Demand Instances that you can run.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>vpc-max-security-groups-per-interface</code>: The maximum number of security groups that you can assign to
     * a network interface.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>max-elastic-ips</code>: The maximum number of Elastic IP addresses that you can allocate for use with
     * EC2-Classic.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>vpc-max-elastic-ips</code>: The maximum number of Elastic IP addresses that you can allocate for use with
     * EC2-VPC.
     * </p>
     * </li>
     * </ul>
     * 
     * @param describeAccountAttributesRequest
     * @return Result of the DescribeAccountAttributes operation returned by the service.
     * @sample AmazonEC2.DescribeAccountAttributes
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeAccountAttributes" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeAccountAttributesResult describeAccountAttributes(DescribeAccountAttributesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeAccountAttributes(request);
    }

    @SdkInternalApi
    final DescribeAccountAttributesResult executeDescribeAccountAttributes(DescribeAccountAttributesRequest describeAccountAttributesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeAccountAttributesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAccountAttributesRequest> request = null;
        Response<DescribeAccountAttributesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAccountAttributesRequestMarshaller().marshall(super.beforeMarshalling(describeAccountAttributesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAccountAttributes");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeAccountAttributesResult> responseHandler = new StaxResponseHandler<DescribeAccountAttributesResult>(
                    new DescribeAccountAttributesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeAccountAttributesResult describeAccountAttributes() {
        return describeAccountAttributes(new DescribeAccountAttributesRequest());
    }

    /**
     * <p>
     * Describes one or more of your Elastic IP addresses.
     * </p>
     * <p>
     * An Elastic IP address is for use in either the EC2-Classic platform or in a VPC. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html">Elastic IP Addresses</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeAddressesRequest
     * @return Result of the DescribeAddresses operation returned by the service.
     * @sample AmazonEC2.DescribeAddresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeAddresses" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeAddressesResult describeAddresses(DescribeAddressesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeAddresses(request);
    }

    @SdkInternalApi
    final DescribeAddressesResult executeDescribeAddresses(DescribeAddressesRequest describeAddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeAddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAddressesRequest> request = null;
        Response<DescribeAddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAddressesRequestMarshaller().marshall(super.beforeMarshalling(describeAddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAddresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeAddressesResult> responseHandler = new StaxResponseHandler<DescribeAddressesResult>(
                    new DescribeAddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeAddressesResult describeAddresses() {
        return describeAddresses(new DescribeAddressesRequest());
    }

    /**
     * <p>
     * Describes the longer ID format settings for all resource types in a specific region. This request is useful for
     * performing a quick audit to determine whether a specific region is fully opted in for longer IDs (17-character
     * IDs).
     * </p>
     * <p>
     * This request only returns information about resource types that support longer IDs.
     * </p>
     * <p>
     * The following resource types support longer IDs: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>instance</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>reservation</code> | <code>route-table</code> |
     * <code>route-table-association</code> | <code>security-group</code> | <code>snapshot</code> | <code>subnet</code>
     * | <code>subnet-cidr-block-association</code> | <code>volume</code> | <code>vpc</code> |
     * <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * 
     * @param describeAggregateIdFormatRequest
     * @return Result of the DescribeAggregateIdFormat operation returned by the service.
     * @sample AmazonEC2.DescribeAggregateIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeAggregateIdFormat" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeAggregateIdFormatResult describeAggregateIdFormat(DescribeAggregateIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeAggregateIdFormat(request);
    }

    @SdkInternalApi
    final DescribeAggregateIdFormatResult executeDescribeAggregateIdFormat(DescribeAggregateIdFormatRequest describeAggregateIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(describeAggregateIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAggregateIdFormatRequest> request = null;
        Response<DescribeAggregateIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAggregateIdFormatRequestMarshaller().marshall(super.beforeMarshalling(describeAggregateIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAggregateIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeAggregateIdFormatResult> responseHandler = new StaxResponseHandler<DescribeAggregateIdFormatResult>(
                    new DescribeAggregateIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of the Availability Zones that are available to you. The results include zones only for the
     * region you're currently using. If there is an event impacting an Availability Zone, you can use this request to
     * view the state and any provided message for that Availability Zone.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html">Regions and
     * Availability Zones</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeAvailabilityZonesRequest
     * @return Result of the DescribeAvailabilityZones operation returned by the service.
     * @sample AmazonEC2.DescribeAvailabilityZones
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeAvailabilityZones" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeAvailabilityZonesResult describeAvailabilityZones(DescribeAvailabilityZonesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeAvailabilityZones(request);
    }

    @SdkInternalApi
    final DescribeAvailabilityZonesResult executeDescribeAvailabilityZones(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeAvailabilityZonesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeAvailabilityZonesRequest> request = null;
        Response<DescribeAvailabilityZonesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeAvailabilityZonesRequestMarshaller().marshall(super.beforeMarshalling(describeAvailabilityZonesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeAvailabilityZones");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeAvailabilityZonesResult> responseHandler = new StaxResponseHandler<DescribeAvailabilityZonesResult>(
                    new DescribeAvailabilityZonesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeAvailabilityZonesResult describeAvailabilityZones() {
        return describeAvailabilityZones(new DescribeAvailabilityZonesRequest());
    }

    /**
     * <p>
     * Describes one or more of your bundling tasks.
     * </p>
     * <note>
     * <p>
     * Completed bundle tasks are listed for only a limited time. If your bundle task is no longer in the list, you can
     * still register an AMI from it. Just use <code>RegisterImage</code> with the Amazon S3 bucket name and image
     * manifest name you provided to the bundle task.
     * </p>
     * </note>
     * 
     * @param describeBundleTasksRequest
     *        Contains the parameters for DescribeBundleTasks.
     * @return Result of the DescribeBundleTasks operation returned by the service.
     * @sample AmazonEC2.DescribeBundleTasks
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeBundleTasks" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeBundleTasksResult describeBundleTasks(DescribeBundleTasksRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeBundleTasks(request);
    }

    @SdkInternalApi
    final DescribeBundleTasksResult executeDescribeBundleTasks(DescribeBundleTasksRequest describeBundleTasksRequest) {

        ExecutionContext executionContext = createExecutionContext(describeBundleTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeBundleTasksRequest> request = null;
        Response<DescribeBundleTasksResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeBundleTasksRequestMarshaller().marshall(super.beforeMarshalling(describeBundleTasksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeBundleTasks");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeBundleTasksResult> responseHandler = new StaxResponseHandler<DescribeBundleTasksResult>(
                    new DescribeBundleTasksResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeBundleTasksResult describeBundleTasks() {
        return describeBundleTasks(new DescribeBundleTasksRequest());
    }

    /**
     * <p>
     * Describes the IP address ranges that were specified in calls to <a>ProvisionByoipCidr</a>.
     * </p>
     * <p>
     * To describe the address pools that were created when you provisioned the address ranges, use
     * <a>DescribePublicIpv4Pools</a>.
     * </p>
     * 
     * @param describeByoipCidrsRequest
     * @return Result of the DescribeByoipCidrs operation returned by the service.
     * @sample AmazonEC2.DescribeByoipCidrs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeByoipCidrs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeByoipCidrsResult describeByoipCidrs(DescribeByoipCidrsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeByoipCidrs(request);
    }

    @SdkInternalApi
    final DescribeByoipCidrsResult executeDescribeByoipCidrs(DescribeByoipCidrsRequest describeByoipCidrsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeByoipCidrsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeByoipCidrsRequest> request = null;
        Response<DescribeByoipCidrsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeByoipCidrsRequestMarshaller().marshall(super.beforeMarshalling(describeByoipCidrsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeByoipCidrs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeByoipCidrsResult> responseHandler = new StaxResponseHandler<DescribeByoipCidrsResult>(
                    new DescribeByoipCidrsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your Capacity Reservations. The results describe only the Capacity Reservations in the
     * AWS Region that you're currently using.
     * </p>
     * 
     * @param describeCapacityReservationsRequest
     * @return Result of the DescribeCapacityReservations operation returned by the service.
     * @sample AmazonEC2.DescribeCapacityReservations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeCapacityReservations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeCapacityReservationsResult describeCapacityReservations(DescribeCapacityReservationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeCapacityReservations(request);
    }

    @SdkInternalApi
    final DescribeCapacityReservationsResult executeDescribeCapacityReservations(DescribeCapacityReservationsRequest describeCapacityReservationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeCapacityReservationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCapacityReservationsRequest> request = null;
        Response<DescribeCapacityReservationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCapacityReservationsRequestMarshaller().marshall(super.beforeMarshalling(describeCapacityReservationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCapacityReservations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeCapacityReservationsResult> responseHandler = new StaxResponseHandler<DescribeCapacityReservationsResult>(
                    new DescribeCapacityReservationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your linked EC2-Classic instances. This request only returns information about
     * EC2-Classic instances linked to a VPC through ClassicLink. You cannot use this request to return information
     * about other instances.
     * </p>
     * 
     * @param describeClassicLinkInstancesRequest
     * @return Result of the DescribeClassicLinkInstances operation returned by the service.
     * @sample AmazonEC2.DescribeClassicLinkInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeClassicLinkInstances"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeClassicLinkInstancesResult describeClassicLinkInstances(DescribeClassicLinkInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeClassicLinkInstances(request);
    }

    @SdkInternalApi
    final DescribeClassicLinkInstancesResult executeDescribeClassicLinkInstances(DescribeClassicLinkInstancesRequest describeClassicLinkInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeClassicLinkInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeClassicLinkInstancesRequest> request = null;
        Response<DescribeClassicLinkInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeClassicLinkInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeClassicLinkInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeClassicLinkInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeClassicLinkInstancesResult> responseHandler = new StaxResponseHandler<DescribeClassicLinkInstancesResult>(
                    new DescribeClassicLinkInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeClassicLinkInstancesResult describeClassicLinkInstances() {
        return describeClassicLinkInstances(new DescribeClassicLinkInstancesRequest());
    }

    /**
     * <p>
     * Describes one or more of your conversion tasks. For more information, see the <a
     * href="http://docs.aws.amazon.com/vm-import/latest/userguide/">VM Import/Export User Guide</a>.
     * </p>
     * <p>
     * For information about the import manifest referenced by this API action, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/APIReference/manifest.html">VM Import Manifest</a>.
     * </p>
     * 
     * @param describeConversionTasksRequest
     *        Contains the parameters for DescribeConversionTasks.
     * @return Result of the DescribeConversionTasks operation returned by the service.
     * @sample AmazonEC2.DescribeConversionTasks
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeConversionTasks" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeConversionTasksResult describeConversionTasks(DescribeConversionTasksRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeConversionTasks(request);
    }

    @SdkInternalApi
    final DescribeConversionTasksResult executeDescribeConversionTasks(DescribeConversionTasksRequest describeConversionTasksRequest) {

        ExecutionContext executionContext = createExecutionContext(describeConversionTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeConversionTasksRequest> request = null;
        Response<DescribeConversionTasksResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeConversionTasksRequestMarshaller().marshall(super.beforeMarshalling(describeConversionTasksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeConversionTasks");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeConversionTasksResult> responseHandler = new StaxResponseHandler<DescribeConversionTasksResult>(
                    new DescribeConversionTasksResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeConversionTasksResult describeConversionTasks() {
        return describeConversionTasks(new DescribeConversionTasksRequest());
    }

    /**
     * <p>
     * Describes one or more of your VPN customer gateways.
     * </p>
     * <p>
     * For more information about VPN customer gateways, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeCustomerGatewaysRequest
     *        Contains the parameters for DescribeCustomerGateways.
     * @return Result of the DescribeCustomerGateways operation returned by the service.
     * @sample AmazonEC2.DescribeCustomerGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeCustomerGateways" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeCustomerGatewaysResult describeCustomerGateways(DescribeCustomerGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeCustomerGateways(request);
    }

    @SdkInternalApi
    final DescribeCustomerGatewaysResult executeDescribeCustomerGateways(DescribeCustomerGatewaysRequest describeCustomerGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeCustomerGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeCustomerGatewaysRequest> request = null;
        Response<DescribeCustomerGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeCustomerGatewaysRequestMarshaller().marshall(super.beforeMarshalling(describeCustomerGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCustomerGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeCustomerGatewaysResult> responseHandler = new StaxResponseHandler<DescribeCustomerGatewaysResult>(
                    new DescribeCustomerGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeCustomerGatewaysResult describeCustomerGateways() {
        return describeCustomerGateways(new DescribeCustomerGatewaysRequest());
    }

    /**
     * <p>
     * Describes one or more of your DHCP options sets.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_DHCP_Options.html">DHCP Options Sets</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeDhcpOptionsRequest
     * @return Result of the DescribeDhcpOptions operation returned by the service.
     * @sample AmazonEC2.DescribeDhcpOptions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeDhcpOptions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeDhcpOptionsResult describeDhcpOptions(DescribeDhcpOptionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeDhcpOptions(request);
    }

    @SdkInternalApi
    final DescribeDhcpOptionsResult executeDescribeDhcpOptions(DescribeDhcpOptionsRequest describeDhcpOptionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeDhcpOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeDhcpOptionsRequest> request = null;
        Response<DescribeDhcpOptionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeDhcpOptionsRequestMarshaller().marshall(super.beforeMarshalling(describeDhcpOptionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeDhcpOptions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeDhcpOptionsResult> responseHandler = new StaxResponseHandler<DescribeDhcpOptionsResult>(
                    new DescribeDhcpOptionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeDhcpOptionsResult describeDhcpOptions() {
        return describeDhcpOptions(new DescribeDhcpOptionsRequest());
    }

    /**
     * <p>
     * Describes one or more of your egress-only internet gateways.
     * </p>
     * 
     * @param describeEgressOnlyInternetGatewaysRequest
     * @return Result of the DescribeEgressOnlyInternetGateways operation returned by the service.
     * @sample AmazonEC2.DescribeEgressOnlyInternetGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeEgressOnlyInternetGateways"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeEgressOnlyInternetGatewaysResult describeEgressOnlyInternetGateways(DescribeEgressOnlyInternetGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeEgressOnlyInternetGateways(request);
    }

    @SdkInternalApi
    final DescribeEgressOnlyInternetGatewaysResult executeDescribeEgressOnlyInternetGateways(
            DescribeEgressOnlyInternetGatewaysRequest describeEgressOnlyInternetGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeEgressOnlyInternetGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeEgressOnlyInternetGatewaysRequest> request = null;
        Response<DescribeEgressOnlyInternetGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeEgressOnlyInternetGatewaysRequestMarshaller()
                        .marshall(super.beforeMarshalling(describeEgressOnlyInternetGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeEgressOnlyInternetGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeEgressOnlyInternetGatewaysResult> responseHandler = new StaxResponseHandler<DescribeEgressOnlyInternetGatewaysResult>(
                    new DescribeEgressOnlyInternetGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the Elastic Graphics accelerator associated with your instances. For more information about Elastic
     * Graphics, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/elastic-graphics.html">Amazon
     * Elastic Graphics</a>.
     * </p>
     * 
     * @param describeElasticGpusRequest
     * @return Result of the DescribeElasticGpus operation returned by the service.
     * @sample AmazonEC2.DescribeElasticGpus
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeElasticGpus" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeElasticGpusResult describeElasticGpus(DescribeElasticGpusRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeElasticGpus(request);
    }

    @SdkInternalApi
    final DescribeElasticGpusResult executeDescribeElasticGpus(DescribeElasticGpusRequest describeElasticGpusRequest) {

        ExecutionContext executionContext = createExecutionContext(describeElasticGpusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeElasticGpusRequest> request = null;
        Response<DescribeElasticGpusResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeElasticGpusRequestMarshaller().marshall(super.beforeMarshalling(describeElasticGpusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeElasticGpus");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeElasticGpusResult> responseHandler = new StaxResponseHandler<DescribeElasticGpusResult>(
                    new DescribeElasticGpusResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your export tasks.
     * </p>
     * 
     * @param describeExportTasksRequest
     *        Contains the parameters for DescribeExportTasks.
     * @return Result of the DescribeExportTasks operation returned by the service.
     * @sample AmazonEC2.DescribeExportTasks
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeExportTasks" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeExportTasksResult describeExportTasks(DescribeExportTasksRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeExportTasks(request);
    }

    @SdkInternalApi
    final DescribeExportTasksResult executeDescribeExportTasks(DescribeExportTasksRequest describeExportTasksRequest) {

        ExecutionContext executionContext = createExecutionContext(describeExportTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeExportTasksRequest> request = null;
        Response<DescribeExportTasksResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeExportTasksRequestMarshaller().marshall(super.beforeMarshalling(describeExportTasksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeExportTasks");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeExportTasksResult> responseHandler = new StaxResponseHandler<DescribeExportTasksResult>(
                    new DescribeExportTasksResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeExportTasksResult describeExportTasks() {
        return describeExportTasks(new DescribeExportTasksRequest());
    }

    /**
     * <p>
     * Describes the events for the specified EC2 Fleet during the specified time.
     * </p>
     * 
     * @param describeFleetHistoryRequest
     * @return Result of the DescribeFleetHistory operation returned by the service.
     * @sample AmazonEC2.DescribeFleetHistory
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFleetHistory" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeFleetHistoryResult describeFleetHistory(DescribeFleetHistoryRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFleetHistory(request);
    }

    @SdkInternalApi
    final DescribeFleetHistoryResult executeDescribeFleetHistory(DescribeFleetHistoryRequest describeFleetHistoryRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFleetHistoryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFleetHistoryRequest> request = null;
        Response<DescribeFleetHistoryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFleetHistoryRequestMarshaller().marshall(super.beforeMarshalling(describeFleetHistoryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFleetHistory");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFleetHistoryResult> responseHandler = new StaxResponseHandler<DescribeFleetHistoryResult>(
                    new DescribeFleetHistoryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the running instances for the specified EC2 Fleet.
     * </p>
     * 
     * @param describeFleetInstancesRequest
     * @return Result of the DescribeFleetInstances operation returned by the service.
     * @sample AmazonEC2.DescribeFleetInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFleetInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeFleetInstancesResult describeFleetInstances(DescribeFleetInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFleetInstances(request);
    }

    @SdkInternalApi
    final DescribeFleetInstancesResult executeDescribeFleetInstances(DescribeFleetInstancesRequest describeFleetInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFleetInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFleetInstancesRequest> request = null;
        Response<DescribeFleetInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFleetInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeFleetInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFleetInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFleetInstancesResult> responseHandler = new StaxResponseHandler<DescribeFleetInstancesResult>(
                    new DescribeFleetInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your EC2 Fleets.
     * </p>
     * 
     * @param describeFleetsRequest
     * @return Result of the DescribeFleets operation returned by the service.
     * @sample AmazonEC2.DescribeFleets
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFleets" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeFleetsResult describeFleets(DescribeFleetsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFleets(request);
    }

    @SdkInternalApi
    final DescribeFleetsResult executeDescribeFleets(DescribeFleetsRequest describeFleetsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFleetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFleetsRequest> request = null;
        Response<DescribeFleetsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFleetsRequestMarshaller().marshall(super.beforeMarshalling(describeFleetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFleets");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFleetsResult> responseHandler = new StaxResponseHandler<DescribeFleetsResult>(
                    new DescribeFleetsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more flow logs. To view the information in your flow logs (the log streams for the network
     * interfaces), you must use the CloudWatch Logs console or the CloudWatch Logs API.
     * </p>
     * 
     * @param describeFlowLogsRequest
     * @return Result of the DescribeFlowLogs operation returned by the service.
     * @sample AmazonEC2.DescribeFlowLogs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFlowLogs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeFlowLogsResult describeFlowLogs(DescribeFlowLogsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFlowLogs(request);
    }

    @SdkInternalApi
    final DescribeFlowLogsResult executeDescribeFlowLogs(DescribeFlowLogsRequest describeFlowLogsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFlowLogsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFlowLogsRequest> request = null;
        Response<DescribeFlowLogsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFlowLogsRequestMarshaller().marshall(super.beforeMarshalling(describeFlowLogsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFlowLogs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFlowLogsResult> responseHandler = new StaxResponseHandler<DescribeFlowLogsResult>(
                    new DescribeFlowLogsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeFlowLogsResult describeFlowLogs() {
        return describeFlowLogs(new DescribeFlowLogsRequest());
    }

    /**
     * <p>
     * Describes the specified attribute of the specified Amazon FPGA Image (AFI).
     * </p>
     * 
     * @param describeFpgaImageAttributeRequest
     * @return Result of the DescribeFpgaImageAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeFpgaImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFpgaImageAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeFpgaImageAttributeResult describeFpgaImageAttribute(DescribeFpgaImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFpgaImageAttribute(request);
    }

    @SdkInternalApi
    final DescribeFpgaImageAttributeResult executeDescribeFpgaImageAttribute(DescribeFpgaImageAttributeRequest describeFpgaImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFpgaImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFpgaImageAttributeRequest> request = null;
        Response<DescribeFpgaImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFpgaImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeFpgaImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFpgaImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFpgaImageAttributeResult> responseHandler = new StaxResponseHandler<DescribeFpgaImageAttributeResult>(
                    new DescribeFpgaImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more available Amazon FPGA Images (AFIs). These include public AFIs, private AFIs that you own,
     * and AFIs owned by other AWS accounts for which you have load permissions.
     * </p>
     * 
     * @param describeFpgaImagesRequest
     * @return Result of the DescribeFpgaImages operation returned by the service.
     * @sample AmazonEC2.DescribeFpgaImages
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeFpgaImages" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeFpgaImagesResult describeFpgaImages(DescribeFpgaImagesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeFpgaImages(request);
    }

    @SdkInternalApi
    final DescribeFpgaImagesResult executeDescribeFpgaImages(DescribeFpgaImagesRequest describeFpgaImagesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeFpgaImagesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeFpgaImagesRequest> request = null;
        Response<DescribeFpgaImagesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeFpgaImagesRequestMarshaller().marshall(super.beforeMarshalling(describeFpgaImagesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeFpgaImages");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeFpgaImagesResult> responseHandler = new StaxResponseHandler<DescribeFpgaImagesResult>(
                    new DescribeFpgaImagesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the Dedicated Host reservations that are available to purchase.
     * </p>
     * <p>
     * The results describe all the Dedicated Host reservation offerings, including offerings that may not match the
     * instance family and region of your Dedicated Hosts. When purchasing an offering, ensure that the instance family
     * and Region of the offering matches that of the Dedicated Hosts with which it is to be associated. For more
     * information about supported instance types, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html">Dedicated Hosts
     * Overview</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeHostReservationOfferingsRequest
     * @return Result of the DescribeHostReservationOfferings operation returned by the service.
     * @sample AmazonEC2.DescribeHostReservationOfferings
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeHostReservationOfferings"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeHostReservationOfferingsResult describeHostReservationOfferings(DescribeHostReservationOfferingsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeHostReservationOfferings(request);
    }

    @SdkInternalApi
    final DescribeHostReservationOfferingsResult executeDescribeHostReservationOfferings(
            DescribeHostReservationOfferingsRequest describeHostReservationOfferingsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeHostReservationOfferingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeHostReservationOfferingsRequest> request = null;
        Response<DescribeHostReservationOfferingsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeHostReservationOfferingsRequestMarshaller().marshall(super.beforeMarshalling(describeHostReservationOfferingsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeHostReservationOfferings");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeHostReservationOfferingsResult> responseHandler = new StaxResponseHandler<DescribeHostReservationOfferingsResult>(
                    new DescribeHostReservationOfferingsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes reservations that are associated with Dedicated Hosts in your account.
     * </p>
     * 
     * @param describeHostReservationsRequest
     * @return Result of the DescribeHostReservations operation returned by the service.
     * @sample AmazonEC2.DescribeHostReservations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeHostReservations" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeHostReservationsResult describeHostReservations(DescribeHostReservationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeHostReservations(request);
    }

    @SdkInternalApi
    final DescribeHostReservationsResult executeDescribeHostReservations(DescribeHostReservationsRequest describeHostReservationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeHostReservationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeHostReservationsRequest> request = null;
        Response<DescribeHostReservationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeHostReservationsRequestMarshaller().marshall(super.beforeMarshalling(describeHostReservationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeHostReservations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeHostReservationsResult> responseHandler = new StaxResponseHandler<DescribeHostReservationsResult>(
                    new DescribeHostReservationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your Dedicated Hosts.
     * </p>
     * <p>
     * The results describe only the Dedicated Hosts in the region you're currently using. All listed instances consume
     * capacity on your Dedicated Host. Dedicated Hosts that have recently been released are listed with the state
     * <code>released</code>.
     * </p>
     * 
     * @param describeHostsRequest
     * @return Result of the DescribeHosts operation returned by the service.
     * @sample AmazonEC2.DescribeHosts
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeHosts" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeHostsResult describeHosts(DescribeHostsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeHosts(request);
    }

    @SdkInternalApi
    final DescribeHostsResult executeDescribeHosts(DescribeHostsRequest describeHostsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeHostsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeHostsRequest> request = null;
        Response<DescribeHostsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeHostsRequestMarshaller().marshall(super.beforeMarshalling(describeHostsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeHosts");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeHostsResult> responseHandler = new StaxResponseHandler<DescribeHostsResult>(new DescribeHostsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeHostsResult describeHosts() {
        return describeHosts(new DescribeHostsRequest());
    }

    /**
     * <p>
     * Describes your IAM instance profile associations.
     * </p>
     * 
     * @param describeIamInstanceProfileAssociationsRequest
     * @return Result of the DescribeIamInstanceProfileAssociations operation returned by the service.
     * @sample AmazonEC2.DescribeIamInstanceProfileAssociations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeIamInstanceProfileAssociations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeIamInstanceProfileAssociationsResult describeIamInstanceProfileAssociations(DescribeIamInstanceProfileAssociationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeIamInstanceProfileAssociations(request);
    }

    @SdkInternalApi
    final DescribeIamInstanceProfileAssociationsResult executeDescribeIamInstanceProfileAssociations(
            DescribeIamInstanceProfileAssociationsRequest describeIamInstanceProfileAssociationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeIamInstanceProfileAssociationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeIamInstanceProfileAssociationsRequest> request = null;
        Response<DescribeIamInstanceProfileAssociationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeIamInstanceProfileAssociationsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeIamInstanceProfileAssociationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeIamInstanceProfileAssociations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeIamInstanceProfileAssociationsResult> responseHandler = new StaxResponseHandler<DescribeIamInstanceProfileAssociationsResult>(
                    new DescribeIamInstanceProfileAssociationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the ID format settings for your resources on a per-region basis, for example, to view which resource
     * types are enabled for longer IDs. This request only returns information about resource types whose ID formats can
     * be modified; it does not return information about other resource types.
     * </p>
     * <p>
     * The following resource types support longer IDs: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>instance</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>reservation</code> | <code>route-table</code> |
     * <code>route-table-association</code> | <code>security-group</code> | <code>snapshot</code> | <code>subnet</code>
     * | <code>subnet-cidr-block-association</code> | <code>volume</code> | <code>vpc</code> |
     * <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * <p>
     * These settings apply to the IAM user who makes the request; they do not apply to the entire AWS account. By
     * default, an IAM user defaults to the same settings as the root user, unless they explicitly override the settings
     * by running the <a>ModifyIdFormat</a> command. Resources created with longer IDs are visible to all IAM users,
     * regardless of these settings and provided that they have permission to use the relevant <code>Describe</code>
     * command for the resource type.
     * </p>
     * 
     * @param describeIdFormatRequest
     * @return Result of the DescribeIdFormat operation returned by the service.
     * @sample AmazonEC2.DescribeIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeIdFormat" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeIdFormatResult describeIdFormat(DescribeIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeIdFormat(request);
    }

    @SdkInternalApi
    final DescribeIdFormatResult executeDescribeIdFormat(DescribeIdFormatRequest describeIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(describeIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeIdFormatRequest> request = null;
        Response<DescribeIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeIdFormatRequestMarshaller().marshall(super.beforeMarshalling(describeIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeIdFormatResult> responseHandler = new StaxResponseHandler<DescribeIdFormatResult>(
                    new DescribeIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeIdFormatResult describeIdFormat() {
        return describeIdFormat(new DescribeIdFormatRequest());
    }

    /**
     * <p>
     * Describes the ID format settings for resources for the specified IAM user, IAM role, or root user. For example,
     * you can view the resource types that are enabled for longer IDs. This request only returns information about
     * resource types whose ID formats can be modified; it does not return information about other resource types. For
     * more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/resource-ids.html">Resource
     * IDs</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * The following resource types support longer IDs: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>instance</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>reservation</code> | <code>route-table</code> |
     * <code>route-table-association</code> | <code>security-group</code> | <code>snapshot</code> | <code>subnet</code>
     * | <code>subnet-cidr-block-association</code> | <code>volume</code> | <code>vpc</code> |
     * <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * <p>
     * These settings apply to the principal specified in the request. They do not apply to the principal that makes the
     * request.
     * </p>
     * 
     * @param describeIdentityIdFormatRequest
     * @return Result of the DescribeIdentityIdFormat operation returned by the service.
     * @sample AmazonEC2.DescribeIdentityIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeIdentityIdFormat" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeIdentityIdFormatResult describeIdentityIdFormat(DescribeIdentityIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeIdentityIdFormat(request);
    }

    @SdkInternalApi
    final DescribeIdentityIdFormatResult executeDescribeIdentityIdFormat(DescribeIdentityIdFormatRequest describeIdentityIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(describeIdentityIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeIdentityIdFormatRequest> request = null;
        Response<DescribeIdentityIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeIdentityIdFormatRequestMarshaller().marshall(super.beforeMarshalling(describeIdentityIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeIdentityIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeIdentityIdFormatResult> responseHandler = new StaxResponseHandler<DescribeIdentityIdFormatResult>(
                    new DescribeIdentityIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the specified attribute of the specified AMI. You can specify only one attribute at a time.
     * </p>
     * 
     * @param describeImageAttributeRequest
     *        Contains the parameters for DescribeImageAttribute.
     * @return Result of the DescribeImageAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeImageAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeImageAttributeResult describeImageAttribute(DescribeImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeImageAttribute(request);
    }

    @SdkInternalApi
    final DescribeImageAttributeResult executeDescribeImageAttribute(DescribeImageAttributeRequest describeImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeImageAttributeRequest> request = null;
        Response<DescribeImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeImageAttributeResult> responseHandler = new StaxResponseHandler<DescribeImageAttributeResult>(
                    new DescribeImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of the images (AMIs, AKIs, and ARIs) available to you. Images available to you include
     * public images, private images that you own, and private images owned by other AWS accounts but for which you have
     * explicit launch permissions.
     * </p>
     * <note>
     * <p>
     * Deregistered images are included in the returned results for an unspecified interval after deregistration.
     * </p>
     * </note>
     * 
     * @param describeImagesRequest
     *        Contains the parameters for DescribeImages.
     * @return Result of the DescribeImages operation returned by the service.
     * @sample AmazonEC2.DescribeImages
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeImages" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeImagesResult describeImages(DescribeImagesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeImages(request);
    }

    @SdkInternalApi
    final DescribeImagesResult executeDescribeImages(DescribeImagesRequest describeImagesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeImagesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeImagesRequest> request = null;
        Response<DescribeImagesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeImagesRequestMarshaller().marshall(super.beforeMarshalling(describeImagesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeImages");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeImagesResult> responseHandler = new StaxResponseHandler<DescribeImagesResult>(
                    new DescribeImagesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeImagesResult describeImages() {
        return describeImages(new DescribeImagesRequest());
    }

    /**
     * <p>
     * Displays details about an import virtual machine or import snapshot tasks that are already created.
     * </p>
     * 
     * @param describeImportImageTasksRequest
     *        Contains the parameters for DescribeImportImageTasks.
     * @return Result of the DescribeImportImageTasks operation returned by the service.
     * @sample AmazonEC2.DescribeImportImageTasks
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeImportImageTasks" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeImportImageTasksResult describeImportImageTasks(DescribeImportImageTasksRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeImportImageTasks(request);
    }

    @SdkInternalApi
    final DescribeImportImageTasksResult executeDescribeImportImageTasks(DescribeImportImageTasksRequest describeImportImageTasksRequest) {

        ExecutionContext executionContext = createExecutionContext(describeImportImageTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeImportImageTasksRequest> request = null;
        Response<DescribeImportImageTasksResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeImportImageTasksRequestMarshaller().marshall(super.beforeMarshalling(describeImportImageTasksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeImportImageTasks");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeImportImageTasksResult> responseHandler = new StaxResponseHandler<DescribeImportImageTasksResult>(
                    new DescribeImportImageTasksResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeImportImageTasksResult describeImportImageTasks() {
        return describeImportImageTasks(new DescribeImportImageTasksRequest());
    }

    /**
     * <p>
     * Describes your import snapshot tasks.
     * </p>
     * 
     * @param describeImportSnapshotTasksRequest
     *        Contains the parameters for DescribeImportSnapshotTasks.
     * @return Result of the DescribeImportSnapshotTasks operation returned by the service.
     * @sample AmazonEC2.DescribeImportSnapshotTasks
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeImportSnapshotTasks"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeImportSnapshotTasksResult describeImportSnapshotTasks(DescribeImportSnapshotTasksRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeImportSnapshotTasks(request);
    }

    @SdkInternalApi
    final DescribeImportSnapshotTasksResult executeDescribeImportSnapshotTasks(DescribeImportSnapshotTasksRequest describeImportSnapshotTasksRequest) {

        ExecutionContext executionContext = createExecutionContext(describeImportSnapshotTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeImportSnapshotTasksRequest> request = null;
        Response<DescribeImportSnapshotTasksResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeImportSnapshotTasksRequestMarshaller().marshall(super.beforeMarshalling(describeImportSnapshotTasksRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeImportSnapshotTasks");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeImportSnapshotTasksResult> responseHandler = new StaxResponseHandler<DescribeImportSnapshotTasksResult>(
                    new DescribeImportSnapshotTasksResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeImportSnapshotTasksResult describeImportSnapshotTasks() {
        return describeImportSnapshotTasks(new DescribeImportSnapshotTasksRequest());
    }

    /**
     * <p>
     * Describes the specified attribute of the specified instance. You can specify only one attribute at a time. Valid
     * attribute values are: <code>instanceType</code> | <code>kernel</code> | <code>ramdisk</code> |
     * <code>userData</code> | <code>disableApiTermination</code> | <code>instanceInitiatedShutdownBehavior</code> |
     * <code>rootDeviceName</code> | <code>blockDeviceMapping</code> | <code>productCodes</code> |
     * <code>sourceDestCheck</code> | <code>groupSet</code> | <code>ebsOptimized</code> | <code>sriovNetSupport</code>
     * </p>
     * 
     * @param describeInstanceAttributeRequest
     *        Contains the parameters for DescribeInstanceAttribute.
     * @return Result of the DescribeInstanceAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeInstanceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeInstanceAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeInstanceAttributeResult describeInstanceAttribute(DescribeInstanceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeInstanceAttribute(request);
    }

    @SdkInternalApi
    final DescribeInstanceAttributeResult executeDescribeInstanceAttribute(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeInstanceAttributeRequest> request = null;
        Response<DescribeInstanceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeInstanceAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeInstanceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeInstanceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeInstanceAttributeResult> responseHandler = new StaxResponseHandler<DescribeInstanceAttributeResult>(
                    new DescribeInstanceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the credit option for CPU usage of one or more of your T2 or T3 instances. The credit options are
     * <code>standard</code> and <code>unlimited</code>.
     * </p>
     * <p>
     * If you do not specify an instance ID, Amazon EC2 returns T2 and T3 instances with the <code>unlimited</code>
     * credit option, as well as instances that were previously configured as T2 or T3 with the <code>unlimited</code>
     * credit option. For example, if you resize a T2 instance, while it is configured as <code>unlimited</code>, to an
     * M4 instance, Amazon EC2 returns the M4 instance.
     * </p>
     * <p>
     * If you specify one or more instance IDs, Amazon EC2 returns the credit option (<code>standard</code> or
     * <code>unlimited</code>) of those instances. If you specify an instance ID that is not valid, such as an instance
     * that is not a T2 or T3 instance, an error is returned.
     * </p>
     * <p>
     * Recently terminated instances might appear in the returned results. This interval is usually less than one hour.
     * </p>
     * <p>
     * If an Availability Zone is experiencing a service disruption and you specify instance IDs in the affected zone,
     * or do not specify any instance IDs at all, the call fails. If you specify only instance IDs in an unaffected
     * zone, the call works normally.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/burstable-performance-instances.html">Burstable
     * Performance Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeInstanceCreditSpecificationsRequest
     * @return Result of the DescribeInstanceCreditSpecifications operation returned by the service.
     * @sample AmazonEC2.DescribeInstanceCreditSpecifications
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeInstanceCreditSpecifications"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeInstanceCreditSpecificationsResult describeInstanceCreditSpecifications(DescribeInstanceCreditSpecificationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeInstanceCreditSpecifications(request);
    }

    @SdkInternalApi
    final DescribeInstanceCreditSpecificationsResult executeDescribeInstanceCreditSpecifications(
            DescribeInstanceCreditSpecificationsRequest describeInstanceCreditSpecificationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeInstanceCreditSpecificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeInstanceCreditSpecificationsRequest> request = null;
        Response<DescribeInstanceCreditSpecificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeInstanceCreditSpecificationsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeInstanceCreditSpecificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeInstanceCreditSpecifications");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeInstanceCreditSpecificationsResult> responseHandler = new StaxResponseHandler<DescribeInstanceCreditSpecificationsResult>(
                    new DescribeInstanceCreditSpecificationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the status of one or more instances. By default, only running instances are described, unless you
     * specifically indicate to return the status of all instances.
     * </p>
     * <p>
     * Instance status includes the following components:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>Status checks</b> - Amazon EC2 performs status checks on running EC2 instances to identify hardware and
     * software issues. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/monitoring-system-instance-status-check.html">Status
     * Checks for Your Instances</a> and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/TroubleshootingInstances.html">Troubleshooting Instances
     * with Failed Status Checks</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Scheduled events</b> - Amazon EC2 can schedule events (such as reboot, stop, or terminate) for your instances
     * related to hardware issues, software updates, or system maintenance. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/monitoring-instances-status-check_sched.html">Scheduled
     * Events for Your Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Instance state</b> - You can manage your instances from the moment you launch them through their termination.
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html">Instance Lifecycle</a> in
     * the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * </li>
     * </ul>
     * 
     * @param describeInstanceStatusRequest
     *        Contains the parameters for DescribeInstanceStatus.
     * @return Result of the DescribeInstanceStatus operation returned by the service.
     * @sample AmazonEC2.DescribeInstanceStatus
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeInstanceStatus" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeInstanceStatusResult describeInstanceStatus(DescribeInstanceStatusRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeInstanceStatus(request);
    }

    @SdkInternalApi
    final DescribeInstanceStatusResult executeDescribeInstanceStatus(DescribeInstanceStatusRequest describeInstanceStatusRequest) {

        ExecutionContext executionContext = createExecutionContext(describeInstanceStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeInstanceStatusRequest> request = null;
        Response<DescribeInstanceStatusResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeInstanceStatusRequestMarshaller().marshall(super.beforeMarshalling(describeInstanceStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeInstanceStatus");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeInstanceStatusResult> responseHandler = new StaxResponseHandler<DescribeInstanceStatusResult>(
                    new DescribeInstanceStatusResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeInstanceStatusResult describeInstanceStatus() {
        return describeInstanceStatus(new DescribeInstanceStatusRequest());
    }

    /**
     * <p>
     * Describes one or more of your instances.
     * </p>
     * <p>
     * If you specify one or more instance IDs, Amazon EC2 returns information for those instances. If you do not
     * specify instance IDs, Amazon EC2 returns information for all relevant instances. If you specify an instance ID
     * that is not valid, an error is returned. If you specify an instance that you do not own, it is not included in
     * the returned results.
     * </p>
     * <p>
     * Recently terminated instances might appear in the returned results. This interval is usually less than one hour.
     * </p>
     * <p>
     * If you describe instances in the rare case where an Availability Zone is experiencing a service disruption and
     * you specify instance IDs that are in the affected zone, or do not specify any instance IDs at all, the call
     * fails. If you describe instances and specify only instance IDs that are in an unaffected zone, the call works
     * normally.
     * </p>
     * 
     * @param describeInstancesRequest
     *        Contains the parameters for DescribeInstances.
     * @return Result of the DescribeInstances operation returned by the service.
     * @sample AmazonEC2.DescribeInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeInstancesResult describeInstances(DescribeInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeInstances(request);
    }

    @SdkInternalApi
    final DescribeInstancesResult executeDescribeInstances(DescribeInstancesRequest describeInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeInstancesRequest> request = null;
        Response<DescribeInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeInstancesResult> responseHandler = new StaxResponseHandler<DescribeInstancesResult>(
                    new DescribeInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeInstancesResult describeInstances() {
        return describeInstances(new DescribeInstancesRequest());
    }

    /**
     * <p>
     * Describes one or more of your internet gateways.
     * </p>
     * 
     * @param describeInternetGatewaysRequest
     * @return Result of the DescribeInternetGateways operation returned by the service.
     * @sample AmazonEC2.DescribeInternetGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeInternetGateways" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeInternetGatewaysResult describeInternetGateways(DescribeInternetGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeInternetGateways(request);
    }

    @SdkInternalApi
    final DescribeInternetGatewaysResult executeDescribeInternetGateways(DescribeInternetGatewaysRequest describeInternetGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeInternetGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeInternetGatewaysRequest> request = null;
        Response<DescribeInternetGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeInternetGatewaysRequestMarshaller().marshall(super.beforeMarshalling(describeInternetGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeInternetGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeInternetGatewaysResult> responseHandler = new StaxResponseHandler<DescribeInternetGatewaysResult>(
                    new DescribeInternetGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeInternetGatewaysResult describeInternetGateways() {
        return describeInternetGateways(new DescribeInternetGatewaysRequest());
    }

    /**
     * <p>
     * Describes one or more of your key pairs.
     * </p>
     * <p>
     * For more information about key pairs, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html">Key Pairs</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeKeyPairsRequest
     * @return Result of the DescribeKeyPairs operation returned by the service.
     * @sample AmazonEC2.DescribeKeyPairs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeKeyPairs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeKeyPairsResult describeKeyPairs(DescribeKeyPairsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeKeyPairs(request);
    }

    @SdkInternalApi
    final DescribeKeyPairsResult executeDescribeKeyPairs(DescribeKeyPairsRequest describeKeyPairsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeKeyPairsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeKeyPairsRequest> request = null;
        Response<DescribeKeyPairsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeKeyPairsRequestMarshaller().marshall(super.beforeMarshalling(describeKeyPairsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeKeyPairs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeKeyPairsResult> responseHandler = new StaxResponseHandler<DescribeKeyPairsResult>(
                    new DescribeKeyPairsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeKeyPairsResult describeKeyPairs() {
        return describeKeyPairs(new DescribeKeyPairsRequest());
    }

    /**
     * <p>
     * Describes one or more versions of a specified launch template. You can describe all versions, individual
     * versions, or a range of versions.
     * </p>
     * 
     * @param describeLaunchTemplateVersionsRequest
     * @return Result of the DescribeLaunchTemplateVersions operation returned by the service.
     * @sample AmazonEC2.DescribeLaunchTemplateVersions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeLaunchTemplateVersions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeLaunchTemplateVersionsResult describeLaunchTemplateVersions(DescribeLaunchTemplateVersionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeLaunchTemplateVersions(request);
    }

    @SdkInternalApi
    final DescribeLaunchTemplateVersionsResult executeDescribeLaunchTemplateVersions(DescribeLaunchTemplateVersionsRequest describeLaunchTemplateVersionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeLaunchTemplateVersionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeLaunchTemplateVersionsRequest> request = null;
        Response<DescribeLaunchTemplateVersionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeLaunchTemplateVersionsRequestMarshaller().marshall(super.beforeMarshalling(describeLaunchTemplateVersionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeLaunchTemplateVersions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeLaunchTemplateVersionsResult> responseHandler = new StaxResponseHandler<DescribeLaunchTemplateVersionsResult>(
                    new DescribeLaunchTemplateVersionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more launch templates.
     * </p>
     * 
     * @param describeLaunchTemplatesRequest
     * @return Result of the DescribeLaunchTemplates operation returned by the service.
     * @sample AmazonEC2.DescribeLaunchTemplates
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeLaunchTemplates" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeLaunchTemplatesResult describeLaunchTemplates(DescribeLaunchTemplatesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeLaunchTemplates(request);
    }

    @SdkInternalApi
    final DescribeLaunchTemplatesResult executeDescribeLaunchTemplates(DescribeLaunchTemplatesRequest describeLaunchTemplatesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeLaunchTemplatesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeLaunchTemplatesRequest> request = null;
        Response<DescribeLaunchTemplatesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeLaunchTemplatesRequestMarshaller().marshall(super.beforeMarshalling(describeLaunchTemplatesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeLaunchTemplates");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeLaunchTemplatesResult> responseHandler = new StaxResponseHandler<DescribeLaunchTemplatesResult>(
                    new DescribeLaunchTemplatesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes your Elastic IP addresses that are being moved to the EC2-VPC platform, or that are being restored to
     * the EC2-Classic platform. This request does not return information about any other Elastic IP addresses in your
     * account.
     * </p>
     * 
     * @param describeMovingAddressesRequest
     * @return Result of the DescribeMovingAddresses operation returned by the service.
     * @sample AmazonEC2.DescribeMovingAddresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeMovingAddresses" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeMovingAddressesResult describeMovingAddresses(DescribeMovingAddressesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeMovingAddresses(request);
    }

    @SdkInternalApi
    final DescribeMovingAddressesResult executeDescribeMovingAddresses(DescribeMovingAddressesRequest describeMovingAddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeMovingAddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeMovingAddressesRequest> request = null;
        Response<DescribeMovingAddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeMovingAddressesRequestMarshaller().marshall(super.beforeMarshalling(describeMovingAddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeMovingAddresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeMovingAddressesResult> responseHandler = new StaxResponseHandler<DescribeMovingAddressesResult>(
                    new DescribeMovingAddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeMovingAddressesResult describeMovingAddresses() {
        return describeMovingAddresses(new DescribeMovingAddressesRequest());
    }

    /**
     * <p>
     * Describes one or more of your NAT gateways.
     * </p>
     * 
     * @param describeNatGatewaysRequest
     * @return Result of the DescribeNatGateways operation returned by the service.
     * @sample AmazonEC2.DescribeNatGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeNatGateways" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeNatGatewaysResult describeNatGateways(DescribeNatGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeNatGateways(request);
    }

    @SdkInternalApi
    final DescribeNatGatewaysResult executeDescribeNatGateways(DescribeNatGatewaysRequest describeNatGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeNatGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeNatGatewaysRequest> request = null;
        Response<DescribeNatGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeNatGatewaysRequestMarshaller().marshall(super.beforeMarshalling(describeNatGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeNatGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeNatGatewaysResult> responseHandler = new StaxResponseHandler<DescribeNatGatewaysResult>(
                    new DescribeNatGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your network ACLs.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html">Network
     * ACLs</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeNetworkAclsRequest
     * @return Result of the DescribeNetworkAcls operation returned by the service.
     * @sample AmazonEC2.DescribeNetworkAcls
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeNetworkAcls" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeNetworkAclsResult describeNetworkAcls(DescribeNetworkAclsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeNetworkAcls(request);
    }

    @SdkInternalApi
    final DescribeNetworkAclsResult executeDescribeNetworkAcls(DescribeNetworkAclsRequest describeNetworkAclsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeNetworkAclsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeNetworkAclsRequest> request = null;
        Response<DescribeNetworkAclsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeNetworkAclsRequestMarshaller().marshall(super.beforeMarshalling(describeNetworkAclsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeNetworkAcls");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeNetworkAclsResult> responseHandler = new StaxResponseHandler<DescribeNetworkAclsResult>(
                    new DescribeNetworkAclsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeNetworkAclsResult describeNetworkAcls() {
        return describeNetworkAcls(new DescribeNetworkAclsRequest());
    }

    /**
     * <p>
     * Describes a network interface attribute. You can specify only one attribute at a time.
     * </p>
     * 
     * @param describeNetworkInterfaceAttributeRequest
     *        Contains the parameters for DescribeNetworkInterfaceAttribute.
     * @return Result of the DescribeNetworkInterfaceAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeNetworkInterfaceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeNetworkInterfaceAttribute"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeNetworkInterfaceAttributeResult describeNetworkInterfaceAttribute(DescribeNetworkInterfaceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeNetworkInterfaceAttribute(request);
    }

    @SdkInternalApi
    final DescribeNetworkInterfaceAttributeResult executeDescribeNetworkInterfaceAttribute(
            DescribeNetworkInterfaceAttributeRequest describeNetworkInterfaceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeNetworkInterfaceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeNetworkInterfaceAttributeRequest> request = null;
        Response<DescribeNetworkInterfaceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeNetworkInterfaceAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeNetworkInterfaceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeNetworkInterfaceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeNetworkInterfaceAttributeResult> responseHandler = new StaxResponseHandler<DescribeNetworkInterfaceAttributeResult>(
                    new DescribeNetworkInterfaceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the permissions for your network interfaces.
     * </p>
     * 
     * @param describeNetworkInterfacePermissionsRequest
     *        Contains the parameters for DescribeNetworkInterfacePermissions.
     * @return Result of the DescribeNetworkInterfacePermissions operation returned by the service.
     * @sample AmazonEC2.DescribeNetworkInterfacePermissions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeNetworkInterfacePermissions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeNetworkInterfacePermissionsResult describeNetworkInterfacePermissions(DescribeNetworkInterfacePermissionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeNetworkInterfacePermissions(request);
    }

    @SdkInternalApi
    final DescribeNetworkInterfacePermissionsResult executeDescribeNetworkInterfacePermissions(
            DescribeNetworkInterfacePermissionsRequest describeNetworkInterfacePermissionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeNetworkInterfacePermissionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeNetworkInterfacePermissionsRequest> request = null;
        Response<DescribeNetworkInterfacePermissionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeNetworkInterfacePermissionsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeNetworkInterfacePermissionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeNetworkInterfacePermissions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeNetworkInterfacePermissionsResult> responseHandler = new StaxResponseHandler<DescribeNetworkInterfacePermissionsResult>(
                    new DescribeNetworkInterfacePermissionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your network interfaces.
     * </p>
     * 
     * @param describeNetworkInterfacesRequest
     *        Contains the parameters for DescribeNetworkInterfaces.
     * @return Result of the DescribeNetworkInterfaces operation returned by the service.
     * @sample AmazonEC2.DescribeNetworkInterfaces
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeNetworkInterfaces" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeNetworkInterfacesResult describeNetworkInterfaces(DescribeNetworkInterfacesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeNetworkInterfaces(request);
    }

    @SdkInternalApi
    final DescribeNetworkInterfacesResult executeDescribeNetworkInterfaces(DescribeNetworkInterfacesRequest describeNetworkInterfacesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeNetworkInterfacesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeNetworkInterfacesRequest> request = null;
        Response<DescribeNetworkInterfacesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeNetworkInterfacesRequestMarshaller().marshall(super.beforeMarshalling(describeNetworkInterfacesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeNetworkInterfaces");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeNetworkInterfacesResult> responseHandler = new StaxResponseHandler<DescribeNetworkInterfacesResult>(
                    new DescribeNetworkInterfacesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeNetworkInterfacesResult describeNetworkInterfaces() {
        return describeNetworkInterfaces(new DescribeNetworkInterfacesRequest());
    }

    /**
     * <p>
     * Describes one or more of your placement groups. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html">Placement Groups</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describePlacementGroupsRequest
     *        Contains the parameters for DescribePlacementGroups.
     * @return Result of the DescribePlacementGroups operation returned by the service.
     * @sample AmazonEC2.DescribePlacementGroups
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribePlacementGroups" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribePlacementGroupsResult describePlacementGroups(DescribePlacementGroupsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribePlacementGroups(request);
    }

    @SdkInternalApi
    final DescribePlacementGroupsResult executeDescribePlacementGroups(DescribePlacementGroupsRequest describePlacementGroupsRequest) {

        ExecutionContext executionContext = createExecutionContext(describePlacementGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribePlacementGroupsRequest> request = null;
        Response<DescribePlacementGroupsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribePlacementGroupsRequestMarshaller().marshall(super.beforeMarshalling(describePlacementGroupsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribePlacementGroups");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribePlacementGroupsResult> responseHandler = new StaxResponseHandler<DescribePlacementGroupsResult>(
                    new DescribePlacementGroupsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribePlacementGroupsResult describePlacementGroups() {
        return describePlacementGroups(new DescribePlacementGroupsRequest());
    }

    /**
     * <p>
     * Describes available AWS services in a prefix list format, which includes the prefix list name and prefix list ID
     * of the service and the IP address range for the service. A prefix list ID is required for creating an outbound
     * security group rule that allows traffic from a VPC to access an AWS service through a gateway VPC endpoint.
     * Currently, the services that support this action are Amazon S3 and Amazon DynamoDB.
     * </p>
     * 
     * @param describePrefixListsRequest
     * @return Result of the DescribePrefixLists operation returned by the service.
     * @sample AmazonEC2.DescribePrefixLists
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribePrefixLists" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribePrefixListsResult describePrefixLists(DescribePrefixListsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribePrefixLists(request);
    }

    @SdkInternalApi
    final DescribePrefixListsResult executeDescribePrefixLists(DescribePrefixListsRequest describePrefixListsRequest) {

        ExecutionContext executionContext = createExecutionContext(describePrefixListsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribePrefixListsRequest> request = null;
        Response<DescribePrefixListsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribePrefixListsRequestMarshaller().marshall(super.beforeMarshalling(describePrefixListsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribePrefixLists");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribePrefixListsResult> responseHandler = new StaxResponseHandler<DescribePrefixListsResult>(
                    new DescribePrefixListsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribePrefixListsResult describePrefixLists() {
        return describePrefixLists(new DescribePrefixListsRequest());
    }

    /**
     * <p>
     * Describes the ID format settings for the root user and all IAM roles and IAM users that have explicitly specified
     * a longer ID (17-character ID) preference.
     * </p>
     * <p>
     * By default, all IAM roles and IAM users default to the same ID settings as the root user, unless they explicitly
     * override the settings. This request is useful for identifying those IAM users and IAM roles that have overridden
     * the default ID settings.
     * </p>
     * <p>
     * The following resource types support longer IDs: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>instance</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>reservation</code> | <code>route-table</code> |
     * <code>route-table-association</code> | <code>security-group</code> | <code>snapshot</code> | <code>subnet</code>
     * | <code>subnet-cidr-block-association</code> | <code>volume</code> | <code>vpc</code> |
     * <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * 
     * @param describePrincipalIdFormatRequest
     * @return Result of the DescribePrincipalIdFormat operation returned by the service.
     * @sample AmazonEC2.DescribePrincipalIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribePrincipalIdFormat" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribePrincipalIdFormatResult describePrincipalIdFormat(DescribePrincipalIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeDescribePrincipalIdFormat(request);
    }

    @SdkInternalApi
    final DescribePrincipalIdFormatResult executeDescribePrincipalIdFormat(DescribePrincipalIdFormatRequest describePrincipalIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(describePrincipalIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribePrincipalIdFormatRequest> request = null;
        Response<DescribePrincipalIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribePrincipalIdFormatRequestMarshaller().marshall(super.beforeMarshalling(describePrincipalIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribePrincipalIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribePrincipalIdFormatResult> responseHandler = new StaxResponseHandler<DescribePrincipalIdFormatResult>(
                    new DescribePrincipalIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the specified IPv4 address pools.
     * </p>
     * 
     * @param describePublicIpv4PoolsRequest
     * @return Result of the DescribePublicIpv4Pools operation returned by the service.
     * @sample AmazonEC2.DescribePublicIpv4Pools
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribePublicIpv4Pools" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribePublicIpv4PoolsResult describePublicIpv4Pools(DescribePublicIpv4PoolsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribePublicIpv4Pools(request);
    }

    @SdkInternalApi
    final DescribePublicIpv4PoolsResult executeDescribePublicIpv4Pools(DescribePublicIpv4PoolsRequest describePublicIpv4PoolsRequest) {

        ExecutionContext executionContext = createExecutionContext(describePublicIpv4PoolsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribePublicIpv4PoolsRequest> request = null;
        Response<DescribePublicIpv4PoolsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribePublicIpv4PoolsRequestMarshaller().marshall(super.beforeMarshalling(describePublicIpv4PoolsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribePublicIpv4Pools");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribePublicIpv4PoolsResult> responseHandler = new StaxResponseHandler<DescribePublicIpv4PoolsResult>(
                    new DescribePublicIpv4PoolsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more regions that are currently available to you.
     * </p>
     * <p>
     * For a list of the regions supported by Amazon EC2, see <a
     * href="http://docs.aws.amazon.com/general/latest/gr/rande.html#ec2_region">Regions and Endpoints</a>.
     * </p>
     * 
     * @param describeRegionsRequest
     * @return Result of the DescribeRegions operation returned by the service.
     * @sample AmazonEC2.DescribeRegions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeRegions" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeRegionsResult describeRegions(DescribeRegionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeRegions(request);
    }

    @SdkInternalApi
    final DescribeRegionsResult executeDescribeRegions(DescribeRegionsRequest describeRegionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeRegionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeRegionsRequest> request = null;
        Response<DescribeRegionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeRegionsRequestMarshaller().marshall(super.beforeMarshalling(describeRegionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeRegions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeRegionsResult> responseHandler = new StaxResponseHandler<DescribeRegionsResult>(
                    new DescribeRegionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeRegionsResult describeRegions() {
        return describeRegions(new DescribeRegionsRequest());
    }

    /**
     * <p>
     * Describes one or more of the Reserved Instances that you purchased.
     * </p>
     * <p>
     * For more information about Reserved Instances, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts-on-demand-reserved-instances.html">Reserved
     * Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeReservedInstancesRequest
     *        Contains the parameters for DescribeReservedInstances.
     * @return Result of the DescribeReservedInstances operation returned by the service.
     * @sample AmazonEC2.DescribeReservedInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeReservedInstances" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeReservedInstancesResult describeReservedInstances(DescribeReservedInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeReservedInstances(request);
    }

    @SdkInternalApi
    final DescribeReservedInstancesResult executeDescribeReservedInstances(DescribeReservedInstancesRequest describeReservedInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeReservedInstancesRequest> request = null;
        Response<DescribeReservedInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeReservedInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeReservedInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeReservedInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeReservedInstancesResult> responseHandler = new StaxResponseHandler<DescribeReservedInstancesResult>(
                    new DescribeReservedInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeReservedInstancesResult describeReservedInstances() {
        return describeReservedInstances(new DescribeReservedInstancesRequest());
    }

    /**
     * <p>
     * Describes your account's Reserved Instance listings in the Reserved Instance Marketplace.
     * </p>
     * <p>
     * The Reserved Instance Marketplace matches sellers who want to resell Reserved Instance capacity that they no
     * longer need with buyers who want to purchase additional capacity. Reserved Instances bought and sold through the
     * Reserved Instance Marketplace work like any other Reserved Instances.
     * </p>
     * <p>
     * As a seller, you choose to list some or all of your Reserved Instances, and you specify the upfront price to
     * receive for them. Your Reserved Instances are then listed in the Reserved Instance Marketplace and are available
     * for purchase.
     * </p>
     * <p>
     * As a buyer, you specify the configuration of the Reserved Instance to purchase, and the Marketplace matches what
     * you're searching for with what's available. The Marketplace first sells the lowest priced Reserved Instances to
     * you, and continues to sell available Reserved Instance listings to you until your demand is met. You are charged
     * based on the total price of all of the listings that you purchase.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-market-general.html">Reserved Instance
     * Marketplace</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeReservedInstancesListingsRequest
     *        Contains the parameters for DescribeReservedInstancesListings.
     * @return Result of the DescribeReservedInstancesListings operation returned by the service.
     * @sample AmazonEC2.DescribeReservedInstancesListings
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeReservedInstancesListings"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeReservedInstancesListingsResult describeReservedInstancesListings(DescribeReservedInstancesListingsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeReservedInstancesListings(request);
    }

    @SdkInternalApi
    final DescribeReservedInstancesListingsResult executeDescribeReservedInstancesListings(
            DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesListingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeReservedInstancesListingsRequest> request = null;
        Response<DescribeReservedInstancesListingsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeReservedInstancesListingsRequestMarshaller().marshall(super.beforeMarshalling(describeReservedInstancesListingsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeReservedInstancesListings");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeReservedInstancesListingsResult> responseHandler = new StaxResponseHandler<DescribeReservedInstancesListingsResult>(
                    new DescribeReservedInstancesListingsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeReservedInstancesListingsResult describeReservedInstancesListings() {
        return describeReservedInstancesListings(new DescribeReservedInstancesListingsRequest());
    }

    /**
     * <p>
     * Describes the modifications made to your Reserved Instances. If no parameter is specified, information about all
     * your Reserved Instances modification requests is returned. If a modification ID is specified, only information
     * about the specific modification is returned.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-modifying.html">Modifying Reserved Instances</a> in
     * the Amazon Elastic Compute Cloud User Guide.
     * </p>
     * 
     * @param describeReservedInstancesModificationsRequest
     *        Contains the parameters for DescribeReservedInstancesModifications.
     * @return Result of the DescribeReservedInstancesModifications operation returned by the service.
     * @sample AmazonEC2.DescribeReservedInstancesModifications
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeReservedInstancesModifications"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeReservedInstancesModificationsResult describeReservedInstancesModifications(DescribeReservedInstancesModificationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeReservedInstancesModifications(request);
    }

    @SdkInternalApi
    final DescribeReservedInstancesModificationsResult executeDescribeReservedInstancesModifications(
            DescribeReservedInstancesModificationsRequest describeReservedInstancesModificationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesModificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeReservedInstancesModificationsRequest> request = null;
        Response<DescribeReservedInstancesModificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeReservedInstancesModificationsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeReservedInstancesModificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeReservedInstancesModifications");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeReservedInstancesModificationsResult> responseHandler = new StaxResponseHandler<DescribeReservedInstancesModificationsResult>(
                    new DescribeReservedInstancesModificationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeReservedInstancesModificationsResult describeReservedInstancesModifications() {
        return describeReservedInstancesModifications(new DescribeReservedInstancesModificationsRequest());
    }

    /**
     * <p>
     * Describes Reserved Instance offerings that are available for purchase. With Reserved Instances, you purchase the
     * right to launch instances for a period of time. During that time period, you do not receive insufficient capacity
     * errors, and you pay a lower usage rate than the rate charged for On-Demand instances for the actual time used.
     * </p>
     * <p>
     * If you have listed your own Reserved Instances for sale in the Reserved Instance Marketplace, they will be
     * excluded from these results. This is to ensure that you do not purchase your own Reserved Instances.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-market-general.html">Reserved Instance
     * Marketplace</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeReservedInstancesOfferingsRequest
     *        Contains the parameters for DescribeReservedInstancesOfferings.
     * @return Result of the DescribeReservedInstancesOfferings operation returned by the service.
     * @sample AmazonEC2.DescribeReservedInstancesOfferings
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeReservedInstancesOfferings"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings(DescribeReservedInstancesOfferingsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeReservedInstancesOfferings(request);
    }

    @SdkInternalApi
    final DescribeReservedInstancesOfferingsResult executeDescribeReservedInstancesOfferings(
            DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesOfferingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeReservedInstancesOfferingsRequest> request = null;
        Response<DescribeReservedInstancesOfferingsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeReservedInstancesOfferingsRequestMarshaller()
                        .marshall(super.beforeMarshalling(describeReservedInstancesOfferingsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeReservedInstancesOfferings");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeReservedInstancesOfferingsResult> responseHandler = new StaxResponseHandler<DescribeReservedInstancesOfferingsResult>(
                    new DescribeReservedInstancesOfferingsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings() {
        return describeReservedInstancesOfferings(new DescribeReservedInstancesOfferingsRequest());
    }

    /**
     * <p>
     * Describes one or more of your route tables.
     * </p>
     * <p>
     * Each subnet in your VPC must be associated with a route table. If a subnet is not explicitly associated with any
     * route table, it is implicitly associated with the main route table. This command does not return the subnet ID
     * for implicit associations.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeRouteTablesRequest
     * @return Result of the DescribeRouteTables operation returned by the service.
     * @sample AmazonEC2.DescribeRouteTables
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeRouteTables" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeRouteTablesResult describeRouteTables(DescribeRouteTablesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeRouteTables(request);
    }

    @SdkInternalApi
    final DescribeRouteTablesResult executeDescribeRouteTables(DescribeRouteTablesRequest describeRouteTablesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeRouteTablesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeRouteTablesRequest> request = null;
        Response<DescribeRouteTablesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeRouteTablesRequestMarshaller().marshall(super.beforeMarshalling(describeRouteTablesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeRouteTables");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeRouteTablesResult> responseHandler = new StaxResponseHandler<DescribeRouteTablesResult>(
                    new DescribeRouteTablesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeRouteTablesResult describeRouteTables() {
        return describeRouteTables(new DescribeRouteTablesRequest());
    }

    /**
     * <p>
     * Finds available schedules that meet the specified criteria.
     * </p>
     * <p>
     * You can search for an available schedule no more than 3 months in advance. You must meet the minimum required
     * duration of 1,200 hours per year. For example, the minimum daily schedule is 4 hours, the minimum weekly schedule
     * is 24 hours, and the minimum monthly schedule is 100 hours.
     * </p>
     * <p>
     * After you find a schedule that meets your needs, call <a>PurchaseScheduledInstances</a> to purchase Scheduled
     * Instances with that schedule.
     * </p>
     * 
     * @param describeScheduledInstanceAvailabilityRequest
     *        Contains the parameters for DescribeScheduledInstanceAvailability.
     * @return Result of the DescribeScheduledInstanceAvailability operation returned by the service.
     * @sample AmazonEC2.DescribeScheduledInstanceAvailability
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeScheduledInstanceAvailability"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeScheduledInstanceAvailabilityResult describeScheduledInstanceAvailability(DescribeScheduledInstanceAvailabilityRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeScheduledInstanceAvailability(request);
    }

    @SdkInternalApi
    final DescribeScheduledInstanceAvailabilityResult executeDescribeScheduledInstanceAvailability(
            DescribeScheduledInstanceAvailabilityRequest describeScheduledInstanceAvailabilityRequest) {

        ExecutionContext executionContext = createExecutionContext(describeScheduledInstanceAvailabilityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScheduledInstanceAvailabilityRequest> request = null;
        Response<DescribeScheduledInstanceAvailabilityResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScheduledInstanceAvailabilityRequestMarshaller().marshall(super
                        .beforeMarshalling(describeScheduledInstanceAvailabilityRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeScheduledInstanceAvailability");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeScheduledInstanceAvailabilityResult> responseHandler = new StaxResponseHandler<DescribeScheduledInstanceAvailabilityResult>(
                    new DescribeScheduledInstanceAvailabilityResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your Scheduled Instances.
     * </p>
     * 
     * @param describeScheduledInstancesRequest
     *        Contains the parameters for DescribeScheduledInstances.
     * @return Result of the DescribeScheduledInstances operation returned by the service.
     * @sample AmazonEC2.DescribeScheduledInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeScheduledInstances" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeScheduledInstancesResult describeScheduledInstances(DescribeScheduledInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeScheduledInstances(request);
    }

    @SdkInternalApi
    final DescribeScheduledInstancesResult executeDescribeScheduledInstances(DescribeScheduledInstancesRequest describeScheduledInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeScheduledInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScheduledInstancesRequest> request = null;
        Response<DescribeScheduledInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScheduledInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeScheduledInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeScheduledInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeScheduledInstancesResult> responseHandler = new StaxResponseHandler<DescribeScheduledInstancesResult>(
                    new DescribeScheduledInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * [EC2-VPC only] Describes the VPCs on the other side of a VPC peering connection that are referencing the security
     * groups you've specified in this request.
     * </p>
     * 
     * @param describeSecurityGroupReferencesRequest
     * @return Result of the DescribeSecurityGroupReferences operation returned by the service.
     * @sample AmazonEC2.DescribeSecurityGroupReferences
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSecurityGroupReferences"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeSecurityGroupReferencesResult describeSecurityGroupReferences(DescribeSecurityGroupReferencesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSecurityGroupReferences(request);
    }

    @SdkInternalApi
    final DescribeSecurityGroupReferencesResult executeDescribeSecurityGroupReferences(
            DescribeSecurityGroupReferencesRequest describeSecurityGroupReferencesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSecurityGroupReferencesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSecurityGroupReferencesRequest> request = null;
        Response<DescribeSecurityGroupReferencesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSecurityGroupReferencesRequestMarshaller().marshall(super.beforeMarshalling(describeSecurityGroupReferencesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSecurityGroupReferences");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSecurityGroupReferencesResult> responseHandler = new StaxResponseHandler<DescribeSecurityGroupReferencesResult>(
                    new DescribeSecurityGroupReferencesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your security groups.
     * </p>
     * <p>
     * A security group is for use with instances either in the EC2-Classic platform or in a specific VPC. For more
     * information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html">Amazon
     * EC2 Security Groups</a> in the <i>Amazon Elastic Compute Cloud User Guide</i> and <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html">Security Groups for Your
     * VPC</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeSecurityGroupsRequest
     * @return Result of the DescribeSecurityGroups operation returned by the service.
     * @sample AmazonEC2.DescribeSecurityGroups
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSecurityGroups" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeSecurityGroupsResult describeSecurityGroups(DescribeSecurityGroupsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSecurityGroups(request);
    }

    @SdkInternalApi
    final DescribeSecurityGroupsResult executeDescribeSecurityGroups(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSecurityGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSecurityGroupsRequest> request = null;
        Response<DescribeSecurityGroupsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSecurityGroupsRequestMarshaller().marshall(super.beforeMarshalling(describeSecurityGroupsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSecurityGroups");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSecurityGroupsResult> responseHandler = new StaxResponseHandler<DescribeSecurityGroupsResult>(
                    new DescribeSecurityGroupsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSecurityGroupsResult describeSecurityGroups() {
        return describeSecurityGroups(new DescribeSecurityGroupsRequest());
    }

    /**
     * <p>
     * Describes the specified attribute of the specified snapshot. You can specify only one attribute at a time.
     * </p>
     * <p>
     * For more information about EBS snapshots, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html">Amazon EBS Snapshots</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeSnapshotAttributeRequest
     *        Contains the parameters for DescribeSnapshotAttribute.
     * @return Result of the DescribeSnapshotAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeSnapshotAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSnapshotAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeSnapshotAttributeResult describeSnapshotAttribute(DescribeSnapshotAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSnapshotAttribute(request);
    }

    @SdkInternalApi
    final DescribeSnapshotAttributeResult executeDescribeSnapshotAttribute(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSnapshotAttributeRequest> request = null;
        Response<DescribeSnapshotAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSnapshotAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeSnapshotAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSnapshotAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSnapshotAttributeResult> responseHandler = new StaxResponseHandler<DescribeSnapshotAttributeResult>(
                    new DescribeSnapshotAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of the EBS snapshots available to you. Available snapshots include public snapshots
     * available for any AWS account to launch, private snapshots that you own, and private snapshots owned by another
     * AWS account but for which you've been given explicit create volume permissions.
     * </p>
     * <p>
     * The create volume permissions fall into the following categories:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <i>public</i>: The owner of the snapshot granted create volume permissions for the snapshot to the
     * <code>all</code> group. All AWS accounts have create volume permissions for these snapshots.
     * </p>
     * </li>
     * <li>
     * <p>
     * <i>explicit</i>: The owner of the snapshot granted create volume permissions to a specific AWS account.
     * </p>
     * </li>
     * <li>
     * <p>
     * <i>implicit</i>: An AWS account has implicit create volume permissions for all snapshots it owns.
     * </p>
     * </li>
     * </ul>
     * <p>
     * The list of snapshots returned can be modified by specifying snapshot IDs, snapshot owners, or AWS accounts with
     * create volume permissions. If no options are specified, Amazon EC2 returns all snapshots for which you have
     * create volume permissions.
     * </p>
     * <p>
     * If you specify one or more snapshot IDs, only snapshots that have the specified IDs are returned. If you specify
     * an invalid snapshot ID, an error is returned. If you specify a snapshot ID for which you do not have access, it
     * is not included in the returned results.
     * </p>
     * <p>
     * If you specify one or more snapshot owners using the <code>OwnerIds</code> option, only snapshots from the
     * specified owners and for which you have access are returned. The results can include the AWS account IDs of the
     * specified owners, <code>amazon</code> for snapshots owned by Amazon, or <code>self</code> for snapshots that you
     * own.
     * </p>
     * <p>
     * If you specify a list of restorable users, only snapshots with create snapshot permissions for those users are
     * returned. You can specify AWS account IDs (if you own the snapshots), <code>self</code> for snapshots for which
     * you own or have explicit permissions, or <code>all</code> for public snapshots.
     * </p>
     * <p>
     * If you are describing a long list of snapshots, you can paginate the output to make the list more manageable. The
     * <code>MaxResults</code> parameter sets the maximum number of results returned in a single page. If the list of
     * results exceeds your <code>MaxResults</code> value, then that number of results is returned along with a
     * <code>NextToken</code> value that can be passed to a subsequent <code>DescribeSnapshots</code> request to
     * retrieve the remaining results.
     * </p>
     * <p>
     * For more information about EBS snapshots, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html">Amazon EBS Snapshots</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeSnapshotsRequest
     *        Contains the parameters for DescribeSnapshots.
     * @return Result of the DescribeSnapshots operation returned by the service.
     * @sample AmazonEC2.DescribeSnapshots
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSnapshots" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSnapshots(request);
    }

    @SdkInternalApi
    final DescribeSnapshotsResult executeDescribeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSnapshotsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSnapshotsRequest> request = null;
        Response<DescribeSnapshotsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSnapshotsRequestMarshaller().marshall(super.beforeMarshalling(describeSnapshotsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSnapshots");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSnapshotsResult> responseHandler = new StaxResponseHandler<DescribeSnapshotsResult>(
                    new DescribeSnapshotsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSnapshotsResult describeSnapshots() {
        return describeSnapshots(new DescribeSnapshotsRequest());
    }

    /**
     * <p>
     * Describes the data feed for Spot Instances. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-data-feeds.html">Spot Instance Data Feed</a> in the
     * <i>Amazon EC2 User Guide for Linux Instances</i>.
     * </p>
     * 
     * @param describeSpotDatafeedSubscriptionRequest
     *        Contains the parameters for DescribeSpotDatafeedSubscription.
     * @return Result of the DescribeSpotDatafeedSubscription operation returned by the service.
     * @sample AmazonEC2.DescribeSpotDatafeedSubscription
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotDatafeedSubscription"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription(DescribeSpotDatafeedSubscriptionRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotDatafeedSubscription(request);
    }

    @SdkInternalApi
    final DescribeSpotDatafeedSubscriptionResult executeDescribeSpotDatafeedSubscription(
            DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotDatafeedSubscriptionRequest> request = null;
        Response<DescribeSpotDatafeedSubscriptionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotDatafeedSubscriptionRequestMarshaller().marshall(super.beforeMarshalling(describeSpotDatafeedSubscriptionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotDatafeedSubscription");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotDatafeedSubscriptionResult> responseHandler = new StaxResponseHandler<DescribeSpotDatafeedSubscriptionResult>(
                    new DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription() {
        return describeSpotDatafeedSubscription(new DescribeSpotDatafeedSubscriptionRequest());
    }

    /**
     * <p>
     * Describes the running instances for the specified Spot Fleet.
     * </p>
     * 
     * @param describeSpotFleetInstancesRequest
     *        Contains the parameters for DescribeSpotFleetInstances.
     * @return Result of the DescribeSpotFleetInstances operation returned by the service.
     * @sample AmazonEC2.DescribeSpotFleetInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotFleetInstances" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeSpotFleetInstancesResult describeSpotFleetInstances(DescribeSpotFleetInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotFleetInstances(request);
    }

    @SdkInternalApi
    final DescribeSpotFleetInstancesResult executeDescribeSpotFleetInstances(DescribeSpotFleetInstancesRequest describeSpotFleetInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotFleetInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotFleetInstancesRequest> request = null;
        Response<DescribeSpotFleetInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotFleetInstancesRequestMarshaller().marshall(super.beforeMarshalling(describeSpotFleetInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotFleetInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotFleetInstancesResult> responseHandler = new StaxResponseHandler<DescribeSpotFleetInstancesResult>(
                    new DescribeSpotFleetInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the events for the specified Spot Fleet request during the specified time.
     * </p>
     * <p>
     * Spot Fleet events are delayed by up to 30 seconds before they can be described. This ensures that you can query
     * by the last evaluated time and not miss a recorded event. Spot Fleet events are available for 48 hours.
     * </p>
     * 
     * @param describeSpotFleetRequestHistoryRequest
     *        Contains the parameters for DescribeSpotFleetRequestHistory.
     * @return Result of the DescribeSpotFleetRequestHistory operation returned by the service.
     * @sample AmazonEC2.DescribeSpotFleetRequestHistory
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotFleetRequestHistory"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeSpotFleetRequestHistoryResult describeSpotFleetRequestHistory(DescribeSpotFleetRequestHistoryRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotFleetRequestHistory(request);
    }

    @SdkInternalApi
    final DescribeSpotFleetRequestHistoryResult executeDescribeSpotFleetRequestHistory(
            DescribeSpotFleetRequestHistoryRequest describeSpotFleetRequestHistoryRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotFleetRequestHistoryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotFleetRequestHistoryRequest> request = null;
        Response<DescribeSpotFleetRequestHistoryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotFleetRequestHistoryRequestMarshaller().marshall(super.beforeMarshalling(describeSpotFleetRequestHistoryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotFleetRequestHistory");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotFleetRequestHistoryResult> responseHandler = new StaxResponseHandler<DescribeSpotFleetRequestHistoryResult>(
                    new DescribeSpotFleetRequestHistoryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes your Spot Fleet requests.
     * </p>
     * <p>
     * Spot Fleet requests are deleted 48 hours after they are canceled and their instances are terminated.
     * </p>
     * 
     * @param describeSpotFleetRequestsRequest
     *        Contains the parameters for DescribeSpotFleetRequests.
     * @return Result of the DescribeSpotFleetRequests operation returned by the service.
     * @sample AmazonEC2.DescribeSpotFleetRequests
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotFleetRequests" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeSpotFleetRequestsResult describeSpotFleetRequests(DescribeSpotFleetRequestsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotFleetRequests(request);
    }

    @SdkInternalApi
    final DescribeSpotFleetRequestsResult executeDescribeSpotFleetRequests(DescribeSpotFleetRequestsRequest describeSpotFleetRequestsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotFleetRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotFleetRequestsRequest> request = null;
        Response<DescribeSpotFleetRequestsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotFleetRequestsRequestMarshaller().marshall(super.beforeMarshalling(describeSpotFleetRequestsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotFleetRequests");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotFleetRequestsResult> responseHandler = new StaxResponseHandler<DescribeSpotFleetRequestsResult>(
                    new DescribeSpotFleetRequestsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSpotFleetRequestsResult describeSpotFleetRequests() {
        return describeSpotFleetRequests(new DescribeSpotFleetRequestsRequest());
    }

    /**
     * <p>
     * Describes the specified Spot Instance requests.
     * </p>
     * <p>
     * You can use <code>DescribeSpotInstanceRequests</code> to find a running Spot Instance by examining the response.
     * If the status of the Spot Instance is <code>fulfilled</code>, the instance ID appears in the response and
     * contains the identifier of the instance. Alternatively, you can use <a>DescribeInstances</a> with a filter to
     * look for instances where the instance lifecycle is <code>spot</code>.
     * </p>
     * <p>
     * Spot Instance requests are deleted four hours after they are canceled and their instances are terminated.
     * </p>
     * 
     * @param describeSpotInstanceRequestsRequest
     *        Contains the parameters for DescribeSpotInstanceRequests.
     * @return Result of the DescribeSpotInstanceRequests operation returned by the service.
     * @sample AmazonEC2.DescribeSpotInstanceRequests
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotInstanceRequests"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests(DescribeSpotInstanceRequestsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotInstanceRequests(request);
    }

    @SdkInternalApi
    final DescribeSpotInstanceRequestsResult executeDescribeSpotInstanceRequests(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotInstanceRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotInstanceRequestsRequest> request = null;
        Response<DescribeSpotInstanceRequestsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotInstanceRequestsRequestMarshaller().marshall(super.beforeMarshalling(describeSpotInstanceRequestsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotInstanceRequests");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotInstanceRequestsResult> responseHandler = new StaxResponseHandler<DescribeSpotInstanceRequestsResult>(
                    new DescribeSpotInstanceRequestsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests() {
        return describeSpotInstanceRequests(new DescribeSpotInstanceRequestsRequest());
    }

    /**
     * <p>
     * Describes the Spot price history. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-spot-instances-history.html">Spot Instance Pricing
     * History</a> in the <i>Amazon EC2 User Guide for Linux Instances</i>.
     * </p>
     * <p>
     * When you specify a start and end time, this operation returns the prices of the instance types within the time
     * range that you specified and the time when the price changed. The price is valid within the time period that you
     * specified; the response merely indicates the last time that the price changed.
     * </p>
     * 
     * @param describeSpotPriceHistoryRequest
     *        Contains the parameters for DescribeSpotPriceHistory.
     * @return Result of the DescribeSpotPriceHistory operation returned by the service.
     * @sample AmazonEC2.DescribeSpotPriceHistory
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSpotPriceHistory" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeSpotPriceHistoryResult describeSpotPriceHistory(DescribeSpotPriceHistoryRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSpotPriceHistory(request);
    }

    @SdkInternalApi
    final DescribeSpotPriceHistoryResult executeDescribeSpotPriceHistory(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSpotPriceHistoryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSpotPriceHistoryRequest> request = null;
        Response<DescribeSpotPriceHistoryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSpotPriceHistoryRequestMarshaller().marshall(super.beforeMarshalling(describeSpotPriceHistoryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSpotPriceHistory");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSpotPriceHistoryResult> responseHandler = new StaxResponseHandler<DescribeSpotPriceHistoryResult>(
                    new DescribeSpotPriceHistoryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSpotPriceHistoryResult describeSpotPriceHistory() {
        return describeSpotPriceHistory(new DescribeSpotPriceHistoryRequest());
    }

    /**
     * <p>
     * [EC2-VPC only] Describes the stale security group rules for security groups in a specified VPC. Rules are stale
     * when they reference a deleted security group in a peer VPC, or a security group in a peer VPC for which the VPC
     * peering connection has been deleted.
     * </p>
     * 
     * @param describeStaleSecurityGroupsRequest
     * @return Result of the DescribeStaleSecurityGroups operation returned by the service.
     * @sample AmazonEC2.DescribeStaleSecurityGroups
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeStaleSecurityGroups"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeStaleSecurityGroupsResult describeStaleSecurityGroups(DescribeStaleSecurityGroupsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeStaleSecurityGroups(request);
    }

    @SdkInternalApi
    final DescribeStaleSecurityGroupsResult executeDescribeStaleSecurityGroups(DescribeStaleSecurityGroupsRequest describeStaleSecurityGroupsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeStaleSecurityGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeStaleSecurityGroupsRequest> request = null;
        Response<DescribeStaleSecurityGroupsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeStaleSecurityGroupsRequestMarshaller().marshall(super.beforeMarshalling(describeStaleSecurityGroupsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeStaleSecurityGroups");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeStaleSecurityGroupsResult> responseHandler = new StaxResponseHandler<DescribeStaleSecurityGroupsResult>(
                    new DescribeStaleSecurityGroupsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more of your subnets.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Subnets.html">Your
     * VPC and Subnets</a> in the <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeSubnetsRequest
     * @return Result of the DescribeSubnets operation returned by the service.
     * @sample AmazonEC2.DescribeSubnets
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeSubnets" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeSubnetsResult describeSubnets(DescribeSubnetsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeSubnets(request);
    }

    @SdkInternalApi
    final DescribeSubnetsResult executeDescribeSubnets(DescribeSubnetsRequest describeSubnetsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeSubnetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeSubnetsRequest> request = null;
        Response<DescribeSubnetsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeSubnetsRequestMarshaller().marshall(super.beforeMarshalling(describeSubnetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeSubnets");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeSubnetsResult> responseHandler = new StaxResponseHandler<DescribeSubnetsResult>(
                    new DescribeSubnetsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeSubnetsResult describeSubnets() {
        return describeSubnets(new DescribeSubnetsRequest());
    }

    /**
     * <p>
     * Describes one or more of the tags for your EC2 resources.
     * </p>
     * <p>
     * For more information about tags, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Resources</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeTagsRequest
     * @return Result of the DescribeTags operation returned by the service.
     * @sample AmazonEC2.DescribeTags
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeTags" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeTagsResult describeTags(DescribeTagsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeTags(request);
    }

    @SdkInternalApi
    final DescribeTagsResult executeDescribeTags(DescribeTagsRequest describeTagsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTagsRequest> request = null;
        Response<DescribeTagsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTagsRequestMarshaller().marshall(super.beforeMarshalling(describeTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTags");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeTagsResult> responseHandler = new StaxResponseHandler<DescribeTagsResult>(new DescribeTagsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeTagsResult describeTags() {
        return describeTags(new DescribeTagsRequest());
    }

    /**
     * <p>
     * Describes one or more attachments between resources and transit gateways. By default, all attachments are
     * described. Alternatively, you can filter the results by attachment ID, attachment state, resource ID, or resource
     * owner.
     * </p>
     * 
     * @param describeTransitGatewayAttachmentsRequest
     * @return Result of the DescribeTransitGatewayAttachments operation returned by the service.
     * @sample AmazonEC2.DescribeTransitGatewayAttachments
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeTransitGatewayAttachments"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeTransitGatewayAttachmentsResult describeTransitGatewayAttachments(DescribeTransitGatewayAttachmentsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeTransitGatewayAttachments(request);
    }

    @SdkInternalApi
    final DescribeTransitGatewayAttachmentsResult executeDescribeTransitGatewayAttachments(
            DescribeTransitGatewayAttachmentsRequest describeTransitGatewayAttachmentsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeTransitGatewayAttachmentsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTransitGatewayAttachmentsRequest> request = null;
        Response<DescribeTransitGatewayAttachmentsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTransitGatewayAttachmentsRequestMarshaller().marshall(super.beforeMarshalling(describeTransitGatewayAttachmentsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTransitGatewayAttachments");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeTransitGatewayAttachmentsResult> responseHandler = new StaxResponseHandler<DescribeTransitGatewayAttachmentsResult>(
                    new DescribeTransitGatewayAttachmentsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more transit gateway route tables. By default, all transit gateway route tables are described.
     * Alternatively, you can filter the results.
     * </p>
     * 
     * @param describeTransitGatewayRouteTablesRequest
     * @return Result of the DescribeTransitGatewayRouteTables operation returned by the service.
     * @sample AmazonEC2.DescribeTransitGatewayRouteTables
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeTransitGatewayRouteTables"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeTransitGatewayRouteTablesResult describeTransitGatewayRouteTables(DescribeTransitGatewayRouteTablesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeTransitGatewayRouteTables(request);
    }

    @SdkInternalApi
    final DescribeTransitGatewayRouteTablesResult executeDescribeTransitGatewayRouteTables(
            DescribeTransitGatewayRouteTablesRequest describeTransitGatewayRouteTablesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeTransitGatewayRouteTablesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTransitGatewayRouteTablesRequest> request = null;
        Response<DescribeTransitGatewayRouteTablesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTransitGatewayRouteTablesRequestMarshaller().marshall(super.beforeMarshalling(describeTransitGatewayRouteTablesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTransitGatewayRouteTables");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeTransitGatewayRouteTablesResult> responseHandler = new StaxResponseHandler<DescribeTransitGatewayRouteTablesResult>(
                    new DescribeTransitGatewayRouteTablesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more VPC attachments. By default, all VPC attachments are described. Alternatively, you can
     * filter the results.
     * </p>
     * 
     * @param describeTransitGatewayVpcAttachmentsRequest
     * @return Result of the DescribeTransitGatewayVpcAttachments operation returned by the service.
     * @sample AmazonEC2.DescribeTransitGatewayVpcAttachments
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeTransitGatewayVpcAttachments"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeTransitGatewayVpcAttachmentsResult describeTransitGatewayVpcAttachments(DescribeTransitGatewayVpcAttachmentsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeTransitGatewayVpcAttachments(request);
    }

    @SdkInternalApi
    final DescribeTransitGatewayVpcAttachmentsResult executeDescribeTransitGatewayVpcAttachments(
            DescribeTransitGatewayVpcAttachmentsRequest describeTransitGatewayVpcAttachmentsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeTransitGatewayVpcAttachmentsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTransitGatewayVpcAttachmentsRequest> request = null;
        Response<DescribeTransitGatewayVpcAttachmentsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTransitGatewayVpcAttachmentsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeTransitGatewayVpcAttachmentsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTransitGatewayVpcAttachments");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeTransitGatewayVpcAttachmentsResult> responseHandler = new StaxResponseHandler<DescribeTransitGatewayVpcAttachmentsResult>(
                    new DescribeTransitGatewayVpcAttachmentsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes one or more transit gateways. By default, all transit gateways are described. Alternatively, you can
     * filter the results.
     * </p>
     * 
     * @param describeTransitGatewaysRequest
     * @return Result of the DescribeTransitGateways operation returned by the service.
     * @sample AmazonEC2.DescribeTransitGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeTransitGateways" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeTransitGatewaysResult describeTransitGateways(DescribeTransitGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeTransitGateways(request);
    }

    @SdkInternalApi
    final DescribeTransitGatewaysResult executeDescribeTransitGateways(DescribeTransitGatewaysRequest describeTransitGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeTransitGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTransitGatewaysRequest> request = null;
        Response<DescribeTransitGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTransitGatewaysRequestMarshaller().marshall(super.beforeMarshalling(describeTransitGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTransitGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeTransitGatewaysResult> responseHandler = new StaxResponseHandler<DescribeTransitGatewaysResult>(
                    new DescribeTransitGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the specified attribute of the specified volume. You can specify only one attribute at a time.
     * </p>
     * <p>
     * For more information about EBS volumes, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumes.html">Amazon EBS Volumes</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVolumeAttributeRequest
     *        Contains the parameters for DescribeVolumeAttribute.
     * @return Result of the DescribeVolumeAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeVolumeAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVolumeAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DescribeVolumeAttributeResult describeVolumeAttribute(DescribeVolumeAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVolumeAttribute(request);
    }

    @SdkInternalApi
    final DescribeVolumeAttributeResult executeDescribeVolumeAttribute(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVolumeAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVolumeAttributeRequest> request = null;
        Response<DescribeVolumeAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVolumeAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeVolumeAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVolumeAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVolumeAttributeResult> responseHandler = new StaxResponseHandler<DescribeVolumeAttributeResult>(
                    new DescribeVolumeAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the status of the specified volumes. Volume status provides the result of the checks performed on your
     * volumes to determine events that can impair the performance of your volumes. The performance of a volume can be
     * affected if an issue occurs on the volume's underlying host. If the volume's underlying host experiences a power
     * outage or system issue, after the system is restored, there could be data inconsistencies on the volume. Volume
     * events notify you if this occurs. Volume actions notify you if any action needs to be taken in response to the
     * event.
     * </p>
     * <p>
     * The <code>DescribeVolumeStatus</code> operation provides the following information about the specified volumes:
     * </p>
     * <p>
     * <i>Status</i>: Reflects the current status of the volume. The possible values are <code>ok</code>,
     * <code>impaired</code> , <code>warning</code>, or <code>insufficient-data</code>. If all checks pass, the overall
     * status of the volume is <code>ok</code>. If the check fails, the overall status is <code>impaired</code>. If the
     * status is <code>insufficient-data</code>, then the checks may still be taking place on your volume at the time.
     * We recommend that you retry the request. For more information about volume status, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/monitoring-volume-status.html">Monitoring the Status of
     * Your Volumes</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * <i>Events</i>: Reflect the cause of a volume status and may require you to take action. For example, if your
     * volume returns an <code>impaired</code> status, then the volume event might be
     * <code>potential-data-inconsistency</code>. This means that your volume has been affected by an issue with the
     * underlying host, has all I/O operations disabled, and may have inconsistent data.
     * </p>
     * <p>
     * <i>Actions</i>: Reflect the actions you may have to take in response to an event. For example, if the status of
     * the volume is <code>impaired</code> and the volume event shows <code>potential-data-inconsistency</code>, then
     * the action shows <code>enable-volume-io</code>. This means that you may want to enable the I/O operations for the
     * volume by calling the <a>EnableVolumeIO</a> action and then check the volume for data consistency.
     * </p>
     * <p>
     * Volume status is based on the volume status checks, and does not reflect the volume state. Therefore, volume
     * status does not indicate volumes in the <code>error</code> state (for example, when a volume is incapable of
     * accepting I/O.)
     * </p>
     * 
     * @param describeVolumeStatusRequest
     *        Contains the parameters for DescribeVolumeStatus.
     * @return Result of the DescribeVolumeStatus operation returned by the service.
     * @sample AmazonEC2.DescribeVolumeStatus
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVolumeStatus" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVolumeStatus(request);
    }

    @SdkInternalApi
    final DescribeVolumeStatusResult executeDescribeVolumeStatus(DescribeVolumeStatusRequest describeVolumeStatusRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVolumeStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVolumeStatusRequest> request = null;
        Response<DescribeVolumeStatusResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVolumeStatusRequestMarshaller().marshall(super.beforeMarshalling(describeVolumeStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVolumeStatus");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVolumeStatusResult> responseHandler = new StaxResponseHandler<DescribeVolumeStatusResult>(
                    new DescribeVolumeStatusResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVolumeStatusResult describeVolumeStatus() {
        return describeVolumeStatus(new DescribeVolumeStatusRequest());
    }

    /**
     * <p>
     * Describes the specified EBS volumes.
     * </p>
     * <p>
     * If you are describing a long list of volumes, you can paginate the output to make the list more manageable. The
     * <code>MaxResults</code> parameter sets the maximum number of results returned in a single page. If the list of
     * results exceeds your <code>MaxResults</code> value, then that number of results is returned along with a
     * <code>NextToken</code> value that can be passed to a subsequent <code>DescribeVolumes</code> request to retrieve
     * the remaining results.
     * </p>
     * <p>
     * For more information about EBS volumes, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumes.html">Amazon EBS Volumes</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVolumesRequest
     *        Contains the parameters for DescribeVolumes.
     * @return Result of the DescribeVolumes operation returned by the service.
     * @sample AmazonEC2.DescribeVolumes
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVolumes" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVolumes(request);
    }

    @SdkInternalApi
    final DescribeVolumesResult executeDescribeVolumes(DescribeVolumesRequest describeVolumesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVolumesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVolumesRequest> request = null;
        Response<DescribeVolumesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVolumesRequestMarshaller().marshall(super.beforeMarshalling(describeVolumesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVolumes");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVolumesResult> responseHandler = new StaxResponseHandler<DescribeVolumesResult>(
                    new DescribeVolumesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVolumesResult describeVolumes() {
        return describeVolumes(new DescribeVolumesRequest());
    }

    /**
     * <p>
     * Reports the current modification status of EBS volumes.
     * </p>
     * <p>
     * Current-generation EBS volumes support modification of attributes including type, size, and (for <code>io1</code>
     * volumes) IOPS provisioning while either attached to or detached from an instance. Following an action from the
     * API or the console to modify a volume, the status of the modification may be <code>modifying</code>,
     * <code>optimizing</code>, <code>completed</code>, or <code>failed</code>. If a volume has never been modified,
     * then certain elements of the returned <code>VolumeModification</code> objects are null.
     * </p>
     * <p>
     * You can also use CloudWatch Events to check the status of a modification to an EBS volume. For information about
     * CloudWatch Events, see the <a href="http://docs.aws.amazon.com/AmazonCloudWatch/latest/events/">Amazon CloudWatch
     * Events User Guide</a>. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html#monitoring_mods">Monitoring
     * Volume Modifications"</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVolumesModificationsRequest
     * @return Result of the DescribeVolumesModifications operation returned by the service.
     * @sample AmazonEC2.DescribeVolumesModifications
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVolumesModifications"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVolumesModificationsResult describeVolumesModifications(DescribeVolumesModificationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVolumesModifications(request);
    }

    @SdkInternalApi
    final DescribeVolumesModificationsResult executeDescribeVolumesModifications(DescribeVolumesModificationsRequest describeVolumesModificationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVolumesModificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVolumesModificationsRequest> request = null;
        Response<DescribeVolumesModificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVolumesModificationsRequestMarshaller().marshall(super.beforeMarshalling(describeVolumesModificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVolumesModifications");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVolumesModificationsResult> responseHandler = new StaxResponseHandler<DescribeVolumesModificationsResult>(
                    new DescribeVolumesModificationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the specified attribute of the specified VPC. You can specify only one attribute at a time.
     * </p>
     * 
     * @param describeVpcAttributeRequest
     * @return Result of the DescribeVpcAttribute operation returned by the service.
     * @sample AmazonEC2.DescribeVpcAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpcAttributeResult describeVpcAttribute(DescribeVpcAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcAttribute(request);
    }

    @SdkInternalApi
    final DescribeVpcAttributeResult executeDescribeVpcAttribute(DescribeVpcAttributeRequest describeVpcAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcAttributeRequest> request = null;
        Response<DescribeVpcAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcAttributeRequestMarshaller().marshall(super.beforeMarshalling(describeVpcAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcAttributeResult> responseHandler = new StaxResponseHandler<DescribeVpcAttributeResult>(
                    new DescribeVpcAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the ClassicLink status of one or more VPCs.
     * </p>
     * 
     * @param describeVpcClassicLinkRequest
     * @return Result of the DescribeVpcClassicLink operation returned by the service.
     * @sample AmazonEC2.DescribeVpcClassicLink
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcClassicLink" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpcClassicLinkResult describeVpcClassicLink(DescribeVpcClassicLinkRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcClassicLink(request);
    }

    @SdkInternalApi
    final DescribeVpcClassicLinkResult executeDescribeVpcClassicLink(DescribeVpcClassicLinkRequest describeVpcClassicLinkRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcClassicLinkRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcClassicLinkRequest> request = null;
        Response<DescribeVpcClassicLinkResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcClassicLinkRequestMarshaller().marshall(super.beforeMarshalling(describeVpcClassicLinkRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcClassicLink");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcClassicLinkResult> responseHandler = new StaxResponseHandler<DescribeVpcClassicLinkResult>(
                    new DescribeVpcClassicLinkResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpcClassicLinkResult describeVpcClassicLink() {
        return describeVpcClassicLink(new DescribeVpcClassicLinkRequest());
    }

    /**
     * <p>
     * Describes the ClassicLink DNS support status of one or more VPCs. If enabled, the DNS hostname of a linked
     * EC2-Classic instance resolves to its private IP address when addressed from an instance in the VPC to which it's
     * linked. Similarly, the DNS hostname of an instance in a VPC resolves to its private IP address when addressed
     * from a linked EC2-Classic instance. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html">ClassicLink</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVpcClassicLinkDnsSupportRequest
     * @return Result of the DescribeVpcClassicLinkDnsSupport operation returned by the service.
     * @sample AmazonEC2.DescribeVpcClassicLinkDnsSupport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcClassicLinkDnsSupport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcClassicLinkDnsSupportResult describeVpcClassicLinkDnsSupport(DescribeVpcClassicLinkDnsSupportRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcClassicLinkDnsSupport(request);
    }

    @SdkInternalApi
    final DescribeVpcClassicLinkDnsSupportResult executeDescribeVpcClassicLinkDnsSupport(
            DescribeVpcClassicLinkDnsSupportRequest describeVpcClassicLinkDnsSupportRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcClassicLinkDnsSupportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcClassicLinkDnsSupportRequest> request = null;
        Response<DescribeVpcClassicLinkDnsSupportResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcClassicLinkDnsSupportRequestMarshaller().marshall(super.beforeMarshalling(describeVpcClassicLinkDnsSupportRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcClassicLinkDnsSupport");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcClassicLinkDnsSupportResult> responseHandler = new StaxResponseHandler<DescribeVpcClassicLinkDnsSupportResult>(
                    new DescribeVpcClassicLinkDnsSupportResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the connection notifications for VPC endpoints and VPC endpoint services.
     * </p>
     * 
     * @param describeVpcEndpointConnectionNotificationsRequest
     * @return Result of the DescribeVpcEndpointConnectionNotifications operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpointConnectionNotifications
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpointConnectionNotifications"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcEndpointConnectionNotificationsResult describeVpcEndpointConnectionNotifications(DescribeVpcEndpointConnectionNotificationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpointConnectionNotifications(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointConnectionNotificationsResult executeDescribeVpcEndpointConnectionNotifications(
            DescribeVpcEndpointConnectionNotificationsRequest describeVpcEndpointConnectionNotificationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointConnectionNotificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointConnectionNotificationsRequest> request = null;
        Response<DescribeVpcEndpointConnectionNotificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointConnectionNotificationsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeVpcEndpointConnectionNotificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpointConnectionNotifications");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointConnectionNotificationsResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointConnectionNotificationsResult>(
                    new DescribeVpcEndpointConnectionNotificationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the VPC endpoint connections to your VPC endpoint services, including any endpoints that are pending
     * your acceptance.
     * </p>
     * 
     * @param describeVpcEndpointConnectionsRequest
     * @return Result of the DescribeVpcEndpointConnections operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpointConnections
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpointConnections"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcEndpointConnectionsResult describeVpcEndpointConnections(DescribeVpcEndpointConnectionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpointConnections(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointConnectionsResult executeDescribeVpcEndpointConnections(DescribeVpcEndpointConnectionsRequest describeVpcEndpointConnectionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointConnectionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointConnectionsRequest> request = null;
        Response<DescribeVpcEndpointConnectionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointConnectionsRequestMarshaller().marshall(super.beforeMarshalling(describeVpcEndpointConnectionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpointConnections");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointConnectionsResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointConnectionsResult>(
                    new DescribeVpcEndpointConnectionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the VPC endpoint service configurations in your account (your services).
     * </p>
     * 
     * @param describeVpcEndpointServiceConfigurationsRequest
     * @return Result of the DescribeVpcEndpointServiceConfigurations operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpointServiceConfigurations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpointServiceConfigurations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcEndpointServiceConfigurationsResult describeVpcEndpointServiceConfigurations(DescribeVpcEndpointServiceConfigurationsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpointServiceConfigurations(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointServiceConfigurationsResult executeDescribeVpcEndpointServiceConfigurations(
            DescribeVpcEndpointServiceConfigurationsRequest describeVpcEndpointServiceConfigurationsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointServiceConfigurationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointServiceConfigurationsRequest> request = null;
        Response<DescribeVpcEndpointServiceConfigurationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointServiceConfigurationsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeVpcEndpointServiceConfigurationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpointServiceConfigurations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointServiceConfigurationsResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointServiceConfigurationsResult>(
                    new DescribeVpcEndpointServiceConfigurationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes the principals (service consumers) that are permitted to discover your VPC endpoint service.
     * </p>
     * 
     * @param describeVpcEndpointServicePermissionsRequest
     * @return Result of the DescribeVpcEndpointServicePermissions operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpointServicePermissions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpointServicePermissions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcEndpointServicePermissionsResult describeVpcEndpointServicePermissions(DescribeVpcEndpointServicePermissionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpointServicePermissions(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointServicePermissionsResult executeDescribeVpcEndpointServicePermissions(
            DescribeVpcEndpointServicePermissionsRequest describeVpcEndpointServicePermissionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointServicePermissionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointServicePermissionsRequest> request = null;
        Response<DescribeVpcEndpointServicePermissionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointServicePermissionsRequestMarshaller().marshall(super
                        .beforeMarshalling(describeVpcEndpointServicePermissionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpointServicePermissions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointServicePermissionsResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointServicePermissionsResult>(
                    new DescribeVpcEndpointServicePermissionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Describes available services to which you can create a VPC endpoint.
     * </p>
     * 
     * @param describeVpcEndpointServicesRequest
     *        Contains the parameters for DescribeVpcEndpointServices.
     * @return Result of the DescribeVpcEndpointServices operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpointServices
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpointServices"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcEndpointServicesResult describeVpcEndpointServices(DescribeVpcEndpointServicesRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpointServices(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointServicesResult executeDescribeVpcEndpointServices(DescribeVpcEndpointServicesRequest describeVpcEndpointServicesRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointServicesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointServicesRequest> request = null;
        Response<DescribeVpcEndpointServicesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointServicesRequestMarshaller().marshall(super.beforeMarshalling(describeVpcEndpointServicesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpointServices");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointServicesResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointServicesResult>(
                    new DescribeVpcEndpointServicesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpcEndpointServicesResult describeVpcEndpointServices() {
        return describeVpcEndpointServices(new DescribeVpcEndpointServicesRequest());
    }

    /**
     * <p>
     * Describes one or more of your VPC endpoints.
     * </p>
     * 
     * @param describeVpcEndpointsRequest
     *        Contains the parameters for DescribeVpcEndpoints.
     * @return Result of the DescribeVpcEndpoints operation returned by the service.
     * @sample AmazonEC2.DescribeVpcEndpoints
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcEndpoints" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpcEndpointsResult describeVpcEndpoints(DescribeVpcEndpointsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcEndpoints(request);
    }

    @SdkInternalApi
    final DescribeVpcEndpointsResult executeDescribeVpcEndpoints(DescribeVpcEndpointsRequest describeVpcEndpointsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcEndpointsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcEndpointsRequest> request = null;
        Response<DescribeVpcEndpointsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcEndpointsRequestMarshaller().marshall(super.beforeMarshalling(describeVpcEndpointsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcEndpoints");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcEndpointsResult> responseHandler = new StaxResponseHandler<DescribeVpcEndpointsResult>(
                    new DescribeVpcEndpointsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpcEndpointsResult describeVpcEndpoints() {
        return describeVpcEndpoints(new DescribeVpcEndpointsRequest());
    }

    /**
     * <p>
     * Describes one or more of your VPC peering connections.
     * </p>
     * 
     * @param describeVpcPeeringConnectionsRequest
     * @return Result of the DescribeVpcPeeringConnections operation returned by the service.
     * @sample AmazonEC2.DescribeVpcPeeringConnections
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcPeeringConnections"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DescribeVpcPeeringConnectionsResult describeVpcPeeringConnections(DescribeVpcPeeringConnectionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcPeeringConnections(request);
    }

    @SdkInternalApi
    final DescribeVpcPeeringConnectionsResult executeDescribeVpcPeeringConnections(DescribeVpcPeeringConnectionsRequest describeVpcPeeringConnectionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcPeeringConnectionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcPeeringConnectionsRequest> request = null;
        Response<DescribeVpcPeeringConnectionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcPeeringConnectionsRequestMarshaller().marshall(super.beforeMarshalling(describeVpcPeeringConnectionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcPeeringConnections");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcPeeringConnectionsResult> responseHandler = new StaxResponseHandler<DescribeVpcPeeringConnectionsResult>(
                    new DescribeVpcPeeringConnectionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpcPeeringConnectionsResult describeVpcPeeringConnections() {
        return describeVpcPeeringConnections(new DescribeVpcPeeringConnectionsRequest());
    }

    /**
     * <p>
     * Describes one or more of your VPCs.
     * </p>
     * 
     * @param describeVpcsRequest
     * @return Result of the DescribeVpcs operation returned by the service.
     * @sample AmazonEC2.DescribeVpcs
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpcs" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpcsResult describeVpcs(DescribeVpcsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpcs(request);
    }

    @SdkInternalApi
    final DescribeVpcsResult executeDescribeVpcs(DescribeVpcsRequest describeVpcsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpcsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpcsRequest> request = null;
        Response<DescribeVpcsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpcsRequestMarshaller().marshall(super.beforeMarshalling(describeVpcsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpcs");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpcsResult> responseHandler = new StaxResponseHandler<DescribeVpcsResult>(new DescribeVpcsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpcsResult describeVpcs() {
        return describeVpcs(new DescribeVpcsRequest());
    }

    /**
     * <p>
     * Describes one or more of your VPN connections.
     * </p>
     * <p>
     * For more information about VPN connections, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVpnConnectionsRequest
     *        Contains the parameters for DescribeVpnConnections.
     * @return Result of the DescribeVpnConnections operation returned by the service.
     * @sample AmazonEC2.DescribeVpnConnections
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpnConnections" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpnConnectionsResult describeVpnConnections(DescribeVpnConnectionsRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpnConnections(request);
    }

    @SdkInternalApi
    final DescribeVpnConnectionsResult executeDescribeVpnConnections(DescribeVpnConnectionsRequest describeVpnConnectionsRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpnConnectionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpnConnectionsRequest> request = null;
        Response<DescribeVpnConnectionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpnConnectionsRequestMarshaller().marshall(super.beforeMarshalling(describeVpnConnectionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpnConnections");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpnConnectionsResult> responseHandler = new StaxResponseHandler<DescribeVpnConnectionsResult>(
                    new DescribeVpnConnectionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpnConnectionsResult describeVpnConnections() {
        return describeVpnConnections(new DescribeVpnConnectionsRequest());
    }

    /**
     * <p>
     * Describes one or more of your virtual private gateways.
     * </p>
     * <p>
     * For more information about virtual private gateways, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_VPN.html">AWS Managed VPN Connections</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param describeVpnGatewaysRequest
     *        Contains the parameters for DescribeVpnGateways.
     * @return Result of the DescribeVpnGateways operation returned by the service.
     * @sample AmazonEC2.DescribeVpnGateways
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DescribeVpnGateways" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DescribeVpnGatewaysResult describeVpnGateways(DescribeVpnGatewaysRequest request) {
        request = beforeClientExecution(request);
        return executeDescribeVpnGateways(request);
    }

    @SdkInternalApi
    final DescribeVpnGatewaysResult executeDescribeVpnGateways(DescribeVpnGatewaysRequest describeVpnGatewaysRequest) {

        ExecutionContext executionContext = createExecutionContext(describeVpnGatewaysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVpnGatewaysRequest> request = null;
        Response<DescribeVpnGatewaysResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVpnGatewaysRequestMarshaller().marshall(super.beforeMarshalling(describeVpnGatewaysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeVpnGateways");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DescribeVpnGatewaysResult> responseHandler = new StaxResponseHandler<DescribeVpnGatewaysResult>(
                    new DescribeVpnGatewaysResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public DescribeVpnGatewaysResult describeVpnGateways() {
        return describeVpnGateways(new DescribeVpnGatewaysRequest());
    }

    /**
     * <p>
     * Unlinks (detaches) a linked EC2-Classic instance from a VPC. After the instance has been unlinked, the VPC
     * security groups are no longer associated with it. An instance is automatically unlinked from a VPC when it's
     * stopped.
     * </p>
     * 
     * @param detachClassicLinkVpcRequest
     * @return Result of the DetachClassicLinkVpc operation returned by the service.
     * @sample AmazonEC2.DetachClassicLinkVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DetachClassicLinkVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DetachClassicLinkVpcResult detachClassicLinkVpc(DetachClassicLinkVpcRequest request) {
        request = beforeClientExecution(request);
        return executeDetachClassicLinkVpc(request);
    }

    @SdkInternalApi
    final DetachClassicLinkVpcResult executeDetachClassicLinkVpc(DetachClassicLinkVpcRequest detachClassicLinkVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(detachClassicLinkVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachClassicLinkVpcRequest> request = null;
        Response<DetachClassicLinkVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachClassicLinkVpcRequestMarshaller().marshall(super.beforeMarshalling(detachClassicLinkVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachClassicLinkVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DetachClassicLinkVpcResult> responseHandler = new StaxResponseHandler<DetachClassicLinkVpcResult>(
                    new DetachClassicLinkVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Detaches an internet gateway from a VPC, disabling connectivity between the internet and the VPC. The VPC must
     * not contain any running instances with Elastic IP addresses or public IPv4 addresses.
     * </p>
     * 
     * @param detachInternetGatewayRequest
     * @return Result of the DetachInternetGateway operation returned by the service.
     * @sample AmazonEC2.DetachInternetGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DetachInternetGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DetachInternetGatewayResult detachInternetGateway(DetachInternetGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDetachInternetGateway(request);
    }

    @SdkInternalApi
    final DetachInternetGatewayResult executeDetachInternetGateway(DetachInternetGatewayRequest detachInternetGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(detachInternetGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachInternetGatewayRequest> request = null;
        Response<DetachInternetGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachInternetGatewayRequestMarshaller().marshall(super.beforeMarshalling(detachInternetGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachInternetGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DetachInternetGatewayResult> responseHandler = new StaxResponseHandler<DetachInternetGatewayResult>(
                    new DetachInternetGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Detaches a network interface from an instance.
     * </p>
     * 
     * @param detachNetworkInterfaceRequest
     *        Contains the parameters for DetachNetworkInterface.
     * @return Result of the DetachNetworkInterface operation returned by the service.
     * @sample AmazonEC2.DetachNetworkInterface
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DetachNetworkInterface" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DetachNetworkInterfaceResult detachNetworkInterface(DetachNetworkInterfaceRequest request) {
        request = beforeClientExecution(request);
        return executeDetachNetworkInterface(request);
    }

    @SdkInternalApi
    final DetachNetworkInterfaceResult executeDetachNetworkInterface(DetachNetworkInterfaceRequest detachNetworkInterfaceRequest) {

        ExecutionContext executionContext = createExecutionContext(detachNetworkInterfaceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachNetworkInterfaceRequest> request = null;
        Response<DetachNetworkInterfaceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachNetworkInterfaceRequestMarshaller().marshall(super.beforeMarshalling(detachNetworkInterfaceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachNetworkInterface");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DetachNetworkInterfaceResult> responseHandler = new StaxResponseHandler<DetachNetworkInterfaceResult>(
                    new DetachNetworkInterfaceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Detaches an EBS volume from an instance. Make sure to unmount any file systems on the device within your
     * operating system before detaching the volume. Failure to do so can result in the volume becoming stuck in the
     * <code>busy</code> state while detaching. If this happens, detachment can be delayed indefinitely until you
     * unmount the volume, force detachment, reboot the instance, or all three. If an EBS volume is the root device of
     * an instance, it can't be detached while the instance is running. To detach the root volume, stop the instance
     * first.
     * </p>
     * <p>
     * When a volume with an AWS Marketplace product code is detached from an instance, the product code is no longer
     * associated with the instance.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html">Detaching an Amazon EBS
     * Volume</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param detachVolumeRequest
     *        Contains the parameters for DetachVolume.
     * @return Result of the DetachVolume operation returned by the service.
     * @sample AmazonEC2.DetachVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DetachVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DetachVolumeResult detachVolume(DetachVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeDetachVolume(request);
    }

    @SdkInternalApi
    final DetachVolumeResult executeDetachVolume(DetachVolumeRequest detachVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(detachVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachVolumeRequest> request = null;
        Response<DetachVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachVolumeRequestMarshaller().marshall(super.beforeMarshalling(detachVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DetachVolumeResult> responseHandler = new StaxResponseHandler<DetachVolumeResult>(new DetachVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Detaches a virtual private gateway from a VPC. You do this if you're planning to turn off the VPC and not use it
     * anymore. You can confirm a virtual private gateway has been completely detached from a VPC by describing the
     * virtual private gateway (any attachments to the virtual private gateway are also described).
     * </p>
     * <p>
     * You must wait for the attachment's state to switch to <code>detached</code> before you can delete the VPC or
     * attach a different VPC to the virtual private gateway.
     * </p>
     * 
     * @param detachVpnGatewayRequest
     *        Contains the parameters for DetachVpnGateway.
     * @return Result of the DetachVpnGateway operation returned by the service.
     * @sample AmazonEC2.DetachVpnGateway
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DetachVpnGateway" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DetachVpnGatewayResult detachVpnGateway(DetachVpnGatewayRequest request) {
        request = beforeClientExecution(request);
        return executeDetachVpnGateway(request);
    }

    @SdkInternalApi
    final DetachVpnGatewayResult executeDetachVpnGateway(DetachVpnGatewayRequest detachVpnGatewayRequest) {

        ExecutionContext executionContext = createExecutionContext(detachVpnGatewayRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DetachVpnGatewayRequest> request = null;
        Response<DetachVpnGatewayResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DetachVpnGatewayRequestMarshaller().marshall(super.beforeMarshalling(detachVpnGatewayRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachVpnGateway");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DetachVpnGatewayResult> responseHandler = new StaxResponseHandler<DetachVpnGatewayResult>(
                    new DetachVpnGatewayResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disables the specified resource attachment from propagating routes to the specified propagation route table.
     * </p>
     * 
     * @param disableTransitGatewayRouteTablePropagationRequest
     * @return Result of the DisableTransitGatewayRouteTablePropagation operation returned by the service.
     * @sample AmazonEC2.DisableTransitGatewayRouteTablePropagation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisableTransitGatewayRouteTablePropagation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisableTransitGatewayRouteTablePropagationResult disableTransitGatewayRouteTablePropagation(DisableTransitGatewayRouteTablePropagationRequest request) {
        request = beforeClientExecution(request);
        return executeDisableTransitGatewayRouteTablePropagation(request);
    }

    @SdkInternalApi
    final DisableTransitGatewayRouteTablePropagationResult executeDisableTransitGatewayRouteTablePropagation(
            DisableTransitGatewayRouteTablePropagationRequest disableTransitGatewayRouteTablePropagationRequest) {

        ExecutionContext executionContext = createExecutionContext(disableTransitGatewayRouteTablePropagationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisableTransitGatewayRouteTablePropagationRequest> request = null;
        Response<DisableTransitGatewayRouteTablePropagationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisableTransitGatewayRouteTablePropagationRequestMarshaller().marshall(super
                        .beforeMarshalling(disableTransitGatewayRouteTablePropagationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableTransitGatewayRouteTablePropagation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisableTransitGatewayRouteTablePropagationResult> responseHandler = new StaxResponseHandler<DisableTransitGatewayRouteTablePropagationResult>(
                    new DisableTransitGatewayRouteTablePropagationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disables a virtual private gateway (VGW) from propagating routes to a specified route table of a VPC.
     * </p>
     * 
     * @param disableVgwRoutePropagationRequest
     *        Contains the parameters for DisableVgwRoutePropagation.
     * @return Result of the DisableVgwRoutePropagation operation returned by the service.
     * @sample AmazonEC2.DisableVgwRoutePropagation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisableVgwRoutePropagation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DisableVgwRoutePropagationResult disableVgwRoutePropagation(DisableVgwRoutePropagationRequest request) {
        request = beforeClientExecution(request);
        return executeDisableVgwRoutePropagation(request);
    }

    @SdkInternalApi
    final DisableVgwRoutePropagationResult executeDisableVgwRoutePropagation(DisableVgwRoutePropagationRequest disableVgwRoutePropagationRequest) {

        ExecutionContext executionContext = createExecutionContext(disableVgwRoutePropagationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisableVgwRoutePropagationRequest> request = null;
        Response<DisableVgwRoutePropagationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisableVgwRoutePropagationRequestMarshaller().marshall(super.beforeMarshalling(disableVgwRoutePropagationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableVgwRoutePropagation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisableVgwRoutePropagationResult> responseHandler = new StaxResponseHandler<DisableVgwRoutePropagationResult>(
                    new DisableVgwRoutePropagationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disables ClassicLink for a VPC. You cannot disable ClassicLink for a VPC that has EC2-Classic instances linked to
     * it.
     * </p>
     * 
     * @param disableVpcClassicLinkRequest
     * @return Result of the DisableVpcClassicLink operation returned by the service.
     * @sample AmazonEC2.DisableVpcClassicLink
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisableVpcClassicLink" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DisableVpcClassicLinkResult disableVpcClassicLink(DisableVpcClassicLinkRequest request) {
        request = beforeClientExecution(request);
        return executeDisableVpcClassicLink(request);
    }

    @SdkInternalApi
    final DisableVpcClassicLinkResult executeDisableVpcClassicLink(DisableVpcClassicLinkRequest disableVpcClassicLinkRequest) {

        ExecutionContext executionContext = createExecutionContext(disableVpcClassicLinkRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisableVpcClassicLinkRequest> request = null;
        Response<DisableVpcClassicLinkResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisableVpcClassicLinkRequestMarshaller().marshall(super.beforeMarshalling(disableVpcClassicLinkRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableVpcClassicLink");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisableVpcClassicLinkResult> responseHandler = new StaxResponseHandler<DisableVpcClassicLinkResult>(
                    new DisableVpcClassicLinkResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disables ClassicLink DNS support for a VPC. If disabled, DNS hostnames resolve to public IP addresses when
     * addressed between a linked EC2-Classic instance and instances in the VPC to which it's linked. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html">ClassicLink</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param disableVpcClassicLinkDnsSupportRequest
     * @return Result of the DisableVpcClassicLinkDnsSupport operation returned by the service.
     * @sample AmazonEC2.DisableVpcClassicLinkDnsSupport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisableVpcClassicLinkDnsSupport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisableVpcClassicLinkDnsSupportResult disableVpcClassicLinkDnsSupport(DisableVpcClassicLinkDnsSupportRequest request) {
        request = beforeClientExecution(request);
        return executeDisableVpcClassicLinkDnsSupport(request);
    }

    @SdkInternalApi
    final DisableVpcClassicLinkDnsSupportResult executeDisableVpcClassicLinkDnsSupport(
            DisableVpcClassicLinkDnsSupportRequest disableVpcClassicLinkDnsSupportRequest) {

        ExecutionContext executionContext = createExecutionContext(disableVpcClassicLinkDnsSupportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisableVpcClassicLinkDnsSupportRequest> request = null;
        Response<DisableVpcClassicLinkDnsSupportResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisableVpcClassicLinkDnsSupportRequestMarshaller().marshall(super.beforeMarshalling(disableVpcClassicLinkDnsSupportRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableVpcClassicLinkDnsSupport");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisableVpcClassicLinkDnsSupportResult> responseHandler = new StaxResponseHandler<DisableVpcClassicLinkDnsSupportResult>(
                    new DisableVpcClassicLinkDnsSupportResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates an Elastic IP address from the instance or network interface it's associated with.
     * </p>
     * <p>
     * An Elastic IP address is for use in either the EC2-Classic platform or in a VPC. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html">Elastic IP Addresses</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * This is an idempotent operation. If you perform the operation more than once, Amazon EC2 doesn't return an error.
     * </p>
     * 
     * @param disassociateAddressRequest
     * @return Result of the DisassociateAddress operation returned by the service.
     * @sample AmazonEC2.DisassociateAddress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateAddress" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DisassociateAddressResult disassociateAddress(DisassociateAddressRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateAddress(request);
    }

    @SdkInternalApi
    final DisassociateAddressResult executeDisassociateAddress(DisassociateAddressRequest disassociateAddressRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateAddressRequest> request = null;
        Response<DisassociateAddressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateAddressRequestMarshaller().marshall(super.beforeMarshalling(disassociateAddressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateAddress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateAddressResult> responseHandler = new StaxResponseHandler<DisassociateAddressResult>(
                    new DisassociateAddressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates an IAM instance profile from a running or stopped instance.
     * </p>
     * <p>
     * Use <a>DescribeIamInstanceProfileAssociations</a> to get the association ID.
     * </p>
     * 
     * @param disassociateIamInstanceProfileRequest
     * @return Result of the DisassociateIamInstanceProfile operation returned by the service.
     * @sample AmazonEC2.DisassociateIamInstanceProfile
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateIamInstanceProfile"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisassociateIamInstanceProfileResult disassociateIamInstanceProfile(DisassociateIamInstanceProfileRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateIamInstanceProfile(request);
    }

    @SdkInternalApi
    final DisassociateIamInstanceProfileResult executeDisassociateIamInstanceProfile(DisassociateIamInstanceProfileRequest disassociateIamInstanceProfileRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateIamInstanceProfileRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateIamInstanceProfileRequest> request = null;
        Response<DisassociateIamInstanceProfileResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateIamInstanceProfileRequestMarshaller().marshall(super.beforeMarshalling(disassociateIamInstanceProfileRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateIamInstanceProfile");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateIamInstanceProfileResult> responseHandler = new StaxResponseHandler<DisassociateIamInstanceProfileResult>(
                    new DisassociateIamInstanceProfileResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates a subnet from a route table.
     * </p>
     * <p>
     * After you perform this action, the subnet no longer uses the routes in the route table. Instead, it uses the
     * routes in the VPC's main route table. For more information about route tables, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param disassociateRouteTableRequest
     * @return Result of the DisassociateRouteTable operation returned by the service.
     * @sample AmazonEC2.DisassociateRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateRouteTable" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public DisassociateRouteTableResult disassociateRouteTable(DisassociateRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateRouteTable(request);
    }

    @SdkInternalApi
    final DisassociateRouteTableResult executeDisassociateRouteTable(DisassociateRouteTableRequest disassociateRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateRouteTableRequest> request = null;
        Response<DisassociateRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateRouteTableRequestMarshaller().marshall(super.beforeMarshalling(disassociateRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateRouteTableResult> responseHandler = new StaxResponseHandler<DisassociateRouteTableResult>(
                    new DisassociateRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates a CIDR block from a subnet. Currently, you can disassociate an IPv6 CIDR block only. You must
     * detach or delete all gateways and resources that are associated with the CIDR block before you can disassociate
     * it.
     * </p>
     * 
     * @param disassociateSubnetCidrBlockRequest
     * @return Result of the DisassociateSubnetCidrBlock operation returned by the service.
     * @sample AmazonEC2.DisassociateSubnetCidrBlock
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateSubnetCidrBlock"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisassociateSubnetCidrBlockResult disassociateSubnetCidrBlock(DisassociateSubnetCidrBlockRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateSubnetCidrBlock(request);
    }

    @SdkInternalApi
    final DisassociateSubnetCidrBlockResult executeDisassociateSubnetCidrBlock(DisassociateSubnetCidrBlockRequest disassociateSubnetCidrBlockRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateSubnetCidrBlockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateSubnetCidrBlockRequest> request = null;
        Response<DisassociateSubnetCidrBlockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateSubnetCidrBlockRequestMarshaller().marshall(super.beforeMarshalling(disassociateSubnetCidrBlockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateSubnetCidrBlock");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateSubnetCidrBlockResult> responseHandler = new StaxResponseHandler<DisassociateSubnetCidrBlockResult>(
                    new DisassociateSubnetCidrBlockResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates a resource attachment from a transit gateway route table.
     * </p>
     * 
     * @param disassociateTransitGatewayRouteTableRequest
     * @return Result of the DisassociateTransitGatewayRouteTable operation returned by the service.
     * @sample AmazonEC2.DisassociateTransitGatewayRouteTable
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateTransitGatewayRouteTable"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public DisassociateTransitGatewayRouteTableResult disassociateTransitGatewayRouteTable(DisassociateTransitGatewayRouteTableRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateTransitGatewayRouteTable(request);
    }

    @SdkInternalApi
    final DisassociateTransitGatewayRouteTableResult executeDisassociateTransitGatewayRouteTable(
            DisassociateTransitGatewayRouteTableRequest disassociateTransitGatewayRouteTableRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateTransitGatewayRouteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateTransitGatewayRouteTableRequest> request = null;
        Response<DisassociateTransitGatewayRouteTableResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateTransitGatewayRouteTableRequestMarshaller().marshall(super
                        .beforeMarshalling(disassociateTransitGatewayRouteTableRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateTransitGatewayRouteTable");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateTransitGatewayRouteTableResult> responseHandler = new StaxResponseHandler<DisassociateTransitGatewayRouteTableResult>(
                    new DisassociateTransitGatewayRouteTableResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disassociates a CIDR block from a VPC. To disassociate the CIDR block, you must specify its association ID. You
     * can get the association ID by using <a>DescribeVpcs</a>. You must detach or delete all gateways and resources
     * that are associated with the CIDR block before you can disassociate it.
     * </p>
     * <p>
     * You cannot disassociate the CIDR block with which you originally created the VPC (the primary CIDR block).
     * </p>
     * 
     * @param disassociateVpcCidrBlockRequest
     * @return Result of the DisassociateVpcCidrBlock operation returned by the service.
     * @sample AmazonEC2.DisassociateVpcCidrBlock
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/DisassociateVpcCidrBlock" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public DisassociateVpcCidrBlockResult disassociateVpcCidrBlock(DisassociateVpcCidrBlockRequest request) {
        request = beforeClientExecution(request);
        return executeDisassociateVpcCidrBlock(request);
    }

    @SdkInternalApi
    final DisassociateVpcCidrBlockResult executeDisassociateVpcCidrBlock(DisassociateVpcCidrBlockRequest disassociateVpcCidrBlockRequest) {

        ExecutionContext executionContext = createExecutionContext(disassociateVpcCidrBlockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DisassociateVpcCidrBlockRequest> request = null;
        Response<DisassociateVpcCidrBlockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DisassociateVpcCidrBlockRequestMarshaller().marshall(super.beforeMarshalling(disassociateVpcCidrBlockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisassociateVpcCidrBlock");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<DisassociateVpcCidrBlockResult> responseHandler = new StaxResponseHandler<DisassociateVpcCidrBlockResult>(
                    new DisassociateVpcCidrBlockResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables the specified attachment to propagate routes to the specified propagation route table.
     * </p>
     * 
     * @param enableTransitGatewayRouteTablePropagationRequest
     * @return Result of the EnableTransitGatewayRouteTablePropagation operation returned by the service.
     * @sample AmazonEC2.EnableTransitGatewayRouteTablePropagation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EnableTransitGatewayRouteTablePropagation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public EnableTransitGatewayRouteTablePropagationResult enableTransitGatewayRouteTablePropagation(EnableTransitGatewayRouteTablePropagationRequest request) {
        request = beforeClientExecution(request);
        return executeEnableTransitGatewayRouteTablePropagation(request);
    }

    @SdkInternalApi
    final EnableTransitGatewayRouteTablePropagationResult executeEnableTransitGatewayRouteTablePropagation(
            EnableTransitGatewayRouteTablePropagationRequest enableTransitGatewayRouteTablePropagationRequest) {

        ExecutionContext executionContext = createExecutionContext(enableTransitGatewayRouteTablePropagationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableTransitGatewayRouteTablePropagationRequest> request = null;
        Response<EnableTransitGatewayRouteTablePropagationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableTransitGatewayRouteTablePropagationRequestMarshaller().marshall(super
                        .beforeMarshalling(enableTransitGatewayRouteTablePropagationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableTransitGatewayRouteTablePropagation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<EnableTransitGatewayRouteTablePropagationResult> responseHandler = new StaxResponseHandler<EnableTransitGatewayRouteTablePropagationResult>(
                    new EnableTransitGatewayRouteTablePropagationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables a virtual private gateway (VGW) to propagate routes to the specified route table of a VPC.
     * </p>
     * 
     * @param enableVgwRoutePropagationRequest
     *        Contains the parameters for EnableVgwRoutePropagation.
     * @return Result of the EnableVgwRoutePropagation operation returned by the service.
     * @sample AmazonEC2.EnableVgwRoutePropagation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EnableVgwRoutePropagation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public EnableVgwRoutePropagationResult enableVgwRoutePropagation(EnableVgwRoutePropagationRequest request) {
        request = beforeClientExecution(request);
        return executeEnableVgwRoutePropagation(request);
    }

    @SdkInternalApi
    final EnableVgwRoutePropagationResult executeEnableVgwRoutePropagation(EnableVgwRoutePropagationRequest enableVgwRoutePropagationRequest) {

        ExecutionContext executionContext = createExecutionContext(enableVgwRoutePropagationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableVgwRoutePropagationRequest> request = null;
        Response<EnableVgwRoutePropagationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableVgwRoutePropagationRequestMarshaller().marshall(super.beforeMarshalling(enableVgwRoutePropagationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableVgwRoutePropagation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<EnableVgwRoutePropagationResult> responseHandler = new StaxResponseHandler<EnableVgwRoutePropagationResult>(
                    new EnableVgwRoutePropagationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables I/O operations for a volume that had I/O operations disabled because the data on the volume was
     * potentially inconsistent.
     * </p>
     * 
     * @param enableVolumeIORequest
     *        Contains the parameters for EnableVolumeIO.
     * @return Result of the EnableVolumeIO operation returned by the service.
     * @sample AmazonEC2.EnableVolumeIO
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EnableVolumeIO" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public EnableVolumeIOResult enableVolumeIO(EnableVolumeIORequest request) {
        request = beforeClientExecution(request);
        return executeEnableVolumeIO(request);
    }

    @SdkInternalApi
    final EnableVolumeIOResult executeEnableVolumeIO(EnableVolumeIORequest enableVolumeIORequest) {

        ExecutionContext executionContext = createExecutionContext(enableVolumeIORequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableVolumeIORequest> request = null;
        Response<EnableVolumeIOResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableVolumeIORequestMarshaller().marshall(super.beforeMarshalling(enableVolumeIORequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableVolumeIO");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<EnableVolumeIOResult> responseHandler = new StaxResponseHandler<EnableVolumeIOResult>(
                    new EnableVolumeIOResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables a VPC for ClassicLink. You can then link EC2-Classic instances to your ClassicLink-enabled VPC to allow
     * communication over private IP addresses. You cannot enable your VPC for ClassicLink if any of your VPC route
     * tables have existing routes for address ranges within the <code>10.0.0.0/8</code> IP address range, excluding
     * local routes for VPCs in the <code>10.0.0.0/16</code> and <code>10.1.0.0/16</code> IP address ranges. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html">ClassicLink</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param enableVpcClassicLinkRequest
     * @return Result of the EnableVpcClassicLink operation returned by the service.
     * @sample AmazonEC2.EnableVpcClassicLink
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EnableVpcClassicLink" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public EnableVpcClassicLinkResult enableVpcClassicLink(EnableVpcClassicLinkRequest request) {
        request = beforeClientExecution(request);
        return executeEnableVpcClassicLink(request);
    }

    @SdkInternalApi
    final EnableVpcClassicLinkResult executeEnableVpcClassicLink(EnableVpcClassicLinkRequest enableVpcClassicLinkRequest) {

        ExecutionContext executionContext = createExecutionContext(enableVpcClassicLinkRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableVpcClassicLinkRequest> request = null;
        Response<EnableVpcClassicLinkResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableVpcClassicLinkRequestMarshaller().marshall(super.beforeMarshalling(enableVpcClassicLinkRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableVpcClassicLink");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<EnableVpcClassicLinkResult> responseHandler = new StaxResponseHandler<EnableVpcClassicLinkResult>(
                    new EnableVpcClassicLinkResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables a VPC to support DNS hostname resolution for ClassicLink. If enabled, the DNS hostname of a linked
     * EC2-Classic instance resolves to its private IP address when addressed from an instance in the VPC to which it's
     * linked. Similarly, the DNS hostname of an instance in a VPC resolves to its private IP address when addressed
     * from a linked EC2-Classic instance. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html">ClassicLink</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param enableVpcClassicLinkDnsSupportRequest
     * @return Result of the EnableVpcClassicLinkDnsSupport operation returned by the service.
     * @sample AmazonEC2.EnableVpcClassicLinkDnsSupport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EnableVpcClassicLinkDnsSupport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public EnableVpcClassicLinkDnsSupportResult enableVpcClassicLinkDnsSupport(EnableVpcClassicLinkDnsSupportRequest request) {
        request = beforeClientExecution(request);
        return executeEnableVpcClassicLinkDnsSupport(request);
    }

    @SdkInternalApi
    final EnableVpcClassicLinkDnsSupportResult executeEnableVpcClassicLinkDnsSupport(EnableVpcClassicLinkDnsSupportRequest enableVpcClassicLinkDnsSupportRequest) {

        ExecutionContext executionContext = createExecutionContext(enableVpcClassicLinkDnsSupportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<EnableVpcClassicLinkDnsSupportRequest> request = null;
        Response<EnableVpcClassicLinkDnsSupportResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new EnableVpcClassicLinkDnsSupportRequestMarshaller().marshall(super.beforeMarshalling(enableVpcClassicLinkDnsSupportRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableVpcClassicLinkDnsSupport");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<EnableVpcClassicLinkDnsSupportResult> responseHandler = new StaxResponseHandler<EnableVpcClassicLinkDnsSupportResult>(
                    new EnableVpcClassicLinkDnsSupportResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Exports routes from the specified transit gateway route table to the specified S3 bucket. By default, all routes
     * are exported. Alternatively, you can filter by CIDR range.
     * </p>
     * 
     * @param exportTransitGatewayRoutesRequest
     * @return Result of the ExportTransitGatewayRoutes operation returned by the service.
     * @sample AmazonEC2.ExportTransitGatewayRoutes
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ExportTransitGatewayRoutes" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ExportTransitGatewayRoutesResult exportTransitGatewayRoutes(ExportTransitGatewayRoutesRequest request) {
        request = beforeClientExecution(request);
        return executeExportTransitGatewayRoutes(request);
    }

    @SdkInternalApi
    final ExportTransitGatewayRoutesResult executeExportTransitGatewayRoutes(ExportTransitGatewayRoutesRequest exportTransitGatewayRoutesRequest) {

        ExecutionContext executionContext = createExecutionContext(exportTransitGatewayRoutesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ExportTransitGatewayRoutesRequest> request = null;
        Response<ExportTransitGatewayRoutesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ExportTransitGatewayRoutesRequestMarshaller().marshall(super.beforeMarshalling(exportTransitGatewayRoutesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ExportTransitGatewayRoutes");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ExportTransitGatewayRoutesResult> responseHandler = new StaxResponseHandler<ExportTransitGatewayRoutesResult>(
                    new ExportTransitGatewayRoutesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Gets the console output for the specified instance. For Linux instances, the instance console output displays the
     * exact console output that would normally be displayed on a physical monitor attached to a computer. For Windows
     * instances, the instance console output includes the last three system event log errors.
     * </p>
     * <p>
     * By default, the console output returns buffered information that was posted shortly after an instance transition
     * state (start, stop, reboot, or terminate). This information is available for at least one hour after the most
     * recent post. Only the most recent 64 KB of console output is available.
     * </p>
     * <p>
     * You can optionally retrieve the latest serial console output at any time during the instance lifecycle. This
     * option is supported on instance types that use the Nitro hypervisor.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-console.html#instance-console-console-output"
     * >Instance Console Output</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param getConsoleOutputRequest
     *        Contains the parameters for GetConsoleOutput.
     * @return Result of the GetConsoleOutput operation returned by the service.
     * @sample AmazonEC2.GetConsoleOutput
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetConsoleOutput" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetConsoleOutputResult getConsoleOutput(GetConsoleOutputRequest request) {
        request = beforeClientExecution(request);
        return executeGetConsoleOutput(request);
    }

    @SdkInternalApi
    final GetConsoleOutputResult executeGetConsoleOutput(GetConsoleOutputRequest getConsoleOutputRequest) {

        ExecutionContext executionContext = createExecutionContext(getConsoleOutputRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetConsoleOutputRequest> request = null;
        Response<GetConsoleOutputResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetConsoleOutputRequestMarshaller().marshall(super.beforeMarshalling(getConsoleOutputRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetConsoleOutput");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetConsoleOutputResult> responseHandler = new StaxResponseHandler<GetConsoleOutputResult>(
                    new GetConsoleOutputResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieve a JPG-format screenshot of a running instance to help with troubleshooting.
     * </p>
     * <p>
     * The returned content is Base64-encoded.
     * </p>
     * 
     * @param getConsoleScreenshotRequest
     *        Contains the parameters for the request.
     * @return Result of the GetConsoleScreenshot operation returned by the service.
     * @sample AmazonEC2.GetConsoleScreenshot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetConsoleScreenshot" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetConsoleScreenshotResult getConsoleScreenshot(GetConsoleScreenshotRequest request) {
        request = beforeClientExecution(request);
        return executeGetConsoleScreenshot(request);
    }

    @SdkInternalApi
    final GetConsoleScreenshotResult executeGetConsoleScreenshot(GetConsoleScreenshotRequest getConsoleScreenshotRequest) {

        ExecutionContext executionContext = createExecutionContext(getConsoleScreenshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetConsoleScreenshotRequest> request = null;
        Response<GetConsoleScreenshotResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetConsoleScreenshotRequestMarshaller().marshall(super.beforeMarshalling(getConsoleScreenshotRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetConsoleScreenshot");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetConsoleScreenshotResult> responseHandler = new StaxResponseHandler<GetConsoleScreenshotResult>(
                    new GetConsoleScreenshotResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Preview a reservation purchase with configurations that match those of your Dedicated Host. You must have active
     * Dedicated Hosts in your account before you purchase a reservation.
     * </p>
     * <p>
     * This is a preview of the <a>PurchaseHostReservation</a> action and does not result in the offering being
     * purchased.
     * </p>
     * 
     * @param getHostReservationPurchasePreviewRequest
     * @return Result of the GetHostReservationPurchasePreview operation returned by the service.
     * @sample AmazonEC2.GetHostReservationPurchasePreview
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetHostReservationPurchasePreview"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetHostReservationPurchasePreviewResult getHostReservationPurchasePreview(GetHostReservationPurchasePreviewRequest request) {
        request = beforeClientExecution(request);
        return executeGetHostReservationPurchasePreview(request);
    }

    @SdkInternalApi
    final GetHostReservationPurchasePreviewResult executeGetHostReservationPurchasePreview(
            GetHostReservationPurchasePreviewRequest getHostReservationPurchasePreviewRequest) {

        ExecutionContext executionContext = createExecutionContext(getHostReservationPurchasePreviewRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHostReservationPurchasePreviewRequest> request = null;
        Response<GetHostReservationPurchasePreviewResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHostReservationPurchasePreviewRequestMarshaller().marshall(super.beforeMarshalling(getHostReservationPurchasePreviewRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetHostReservationPurchasePreview");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetHostReservationPurchasePreviewResult> responseHandler = new StaxResponseHandler<GetHostReservationPurchasePreviewResult>(
                    new GetHostReservationPurchasePreviewResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieves the configuration data of the specified instance. You can use this data to create a launch template.
     * </p>
     * 
     * @param getLaunchTemplateDataRequest
     * @return Result of the GetLaunchTemplateData operation returned by the service.
     * @sample AmazonEC2.GetLaunchTemplateData
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetLaunchTemplateData" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetLaunchTemplateDataResult getLaunchTemplateData(GetLaunchTemplateDataRequest request) {
        request = beforeClientExecution(request);
        return executeGetLaunchTemplateData(request);
    }

    @SdkInternalApi
    final GetLaunchTemplateDataResult executeGetLaunchTemplateData(GetLaunchTemplateDataRequest getLaunchTemplateDataRequest) {

        ExecutionContext executionContext = createExecutionContext(getLaunchTemplateDataRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetLaunchTemplateDataRequest> request = null;
        Response<GetLaunchTemplateDataResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetLaunchTemplateDataRequestMarshaller().marshall(super.beforeMarshalling(getLaunchTemplateDataRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetLaunchTemplateData");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetLaunchTemplateDataResult> responseHandler = new StaxResponseHandler<GetLaunchTemplateDataResult>(
                    new GetLaunchTemplateDataResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Retrieves the encrypted administrator password for a running Windows instance.
     * </p>
     * <p>
     * The Windows password is generated at boot by the <code>EC2Config</code> service or <code>EC2Launch</code> scripts
     * (Windows Server 2016 and later). This usually only happens the first time an instance is launched. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/UsingConfig_WinAMI.html">EC2Config</a> and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2launch.html">EC2Launch</a> in the Amazon Elastic
     * Compute Cloud User Guide.
     * </p>
     * <p>
     * For the <code>EC2Config</code> service, the password is not generated for rebundled AMIs unless
     * <code>Ec2SetPassword</code> is enabled before bundling.
     * </p>
     * <p>
     * The password is encrypted using the key pair that you specified when you launched the instance. You must provide
     * the corresponding key pair file.
     * </p>
     * <p>
     * When you launch an instance, password generation and encryption may take a few minutes. If you try to retrieve
     * the password before it's available, the output returns an empty string. We recommend that you wait up to 15
     * minutes after launching an instance before trying to retrieve the generated password.
     * </p>
     * 
     * @param getPasswordDataRequest
     *        Contains the parameters for GetPasswordData.
     * @return Result of the GetPasswordData operation returned by the service.
     * @sample AmazonEC2.GetPasswordData
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetPasswordData" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public GetPasswordDataResult getPasswordData(GetPasswordDataRequest request) {
        request = beforeClientExecution(request);
        return executeGetPasswordData(request);
    }

    @SdkInternalApi
    final GetPasswordDataResult executeGetPasswordData(GetPasswordDataRequest getPasswordDataRequest) {

        ExecutionContext executionContext = createExecutionContext(getPasswordDataRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetPasswordDataRequest> request = null;
        Response<GetPasswordDataResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetPasswordDataRequestMarshaller().marshall(super.beforeMarshalling(getPasswordDataRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetPasswordData");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetPasswordDataResult> responseHandler = new StaxResponseHandler<GetPasswordDataResult>(
                    new GetPasswordDataResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Returns a quote and exchange information for exchanging one or more specified Convertible Reserved Instances for
     * a new Convertible Reserved Instance. If the exchange cannot be performed, the reason is returned in the response.
     * Use <a>AcceptReservedInstancesExchangeQuote</a> to perform the exchange.
     * </p>
     * 
     * @param getReservedInstancesExchangeQuoteRequest
     *        Contains the parameters for GetReservedInstanceExchangeQuote.
     * @return Result of the GetReservedInstancesExchangeQuote operation returned by the service.
     * @sample AmazonEC2.GetReservedInstancesExchangeQuote
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetReservedInstancesExchangeQuote"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetReservedInstancesExchangeQuoteResult getReservedInstancesExchangeQuote(GetReservedInstancesExchangeQuoteRequest request) {
        request = beforeClientExecution(request);
        return executeGetReservedInstancesExchangeQuote(request);
    }

    @SdkInternalApi
    final GetReservedInstancesExchangeQuoteResult executeGetReservedInstancesExchangeQuote(
            GetReservedInstancesExchangeQuoteRequest getReservedInstancesExchangeQuoteRequest) {

        ExecutionContext executionContext = createExecutionContext(getReservedInstancesExchangeQuoteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetReservedInstancesExchangeQuoteRequest> request = null;
        Response<GetReservedInstancesExchangeQuoteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetReservedInstancesExchangeQuoteRequestMarshaller().marshall(super.beforeMarshalling(getReservedInstancesExchangeQuoteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetReservedInstancesExchangeQuote");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetReservedInstancesExchangeQuoteResult> responseHandler = new StaxResponseHandler<GetReservedInstancesExchangeQuoteResult>(
                    new GetReservedInstancesExchangeQuoteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Lists the route tables to which the specified resource attachment propagates routes.
     * </p>
     * 
     * @param getTransitGatewayAttachmentPropagationsRequest
     * @return Result of the GetTransitGatewayAttachmentPropagations operation returned by the service.
     * @sample AmazonEC2.GetTransitGatewayAttachmentPropagations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetTransitGatewayAttachmentPropagations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetTransitGatewayAttachmentPropagationsResult getTransitGatewayAttachmentPropagations(GetTransitGatewayAttachmentPropagationsRequest request) {
        request = beforeClientExecution(request);
        return executeGetTransitGatewayAttachmentPropagations(request);
    }

    @SdkInternalApi
    final GetTransitGatewayAttachmentPropagationsResult executeGetTransitGatewayAttachmentPropagations(
            GetTransitGatewayAttachmentPropagationsRequest getTransitGatewayAttachmentPropagationsRequest) {

        ExecutionContext executionContext = createExecutionContext(getTransitGatewayAttachmentPropagationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTransitGatewayAttachmentPropagationsRequest> request = null;
        Response<GetTransitGatewayAttachmentPropagationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTransitGatewayAttachmentPropagationsRequestMarshaller().marshall(super
                        .beforeMarshalling(getTransitGatewayAttachmentPropagationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetTransitGatewayAttachmentPropagations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetTransitGatewayAttachmentPropagationsResult> responseHandler = new StaxResponseHandler<GetTransitGatewayAttachmentPropagationsResult>(
                    new GetTransitGatewayAttachmentPropagationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Gets information about the associations for the specified transit gateway route table.
     * </p>
     * 
     * @param getTransitGatewayRouteTableAssociationsRequest
     * @return Result of the GetTransitGatewayRouteTableAssociations operation returned by the service.
     * @sample AmazonEC2.GetTransitGatewayRouteTableAssociations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetTransitGatewayRouteTableAssociations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetTransitGatewayRouteTableAssociationsResult getTransitGatewayRouteTableAssociations(GetTransitGatewayRouteTableAssociationsRequest request) {
        request = beforeClientExecution(request);
        return executeGetTransitGatewayRouteTableAssociations(request);
    }

    @SdkInternalApi
    final GetTransitGatewayRouteTableAssociationsResult executeGetTransitGatewayRouteTableAssociations(
            GetTransitGatewayRouteTableAssociationsRequest getTransitGatewayRouteTableAssociationsRequest) {

        ExecutionContext executionContext = createExecutionContext(getTransitGatewayRouteTableAssociationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTransitGatewayRouteTableAssociationsRequest> request = null;
        Response<GetTransitGatewayRouteTableAssociationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTransitGatewayRouteTableAssociationsRequestMarshaller().marshall(super
                        .beforeMarshalling(getTransitGatewayRouteTableAssociationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetTransitGatewayRouteTableAssociations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetTransitGatewayRouteTableAssociationsResult> responseHandler = new StaxResponseHandler<GetTransitGatewayRouteTableAssociationsResult>(
                    new GetTransitGatewayRouteTableAssociationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Gets information about the route table propagations for the specified transit gateway route table.
     * </p>
     * 
     * @param getTransitGatewayRouteTablePropagationsRequest
     * @return Result of the GetTransitGatewayRouteTablePropagations operation returned by the service.
     * @sample AmazonEC2.GetTransitGatewayRouteTablePropagations
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/GetTransitGatewayRouteTablePropagations"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetTransitGatewayRouteTablePropagationsResult getTransitGatewayRouteTablePropagations(GetTransitGatewayRouteTablePropagationsRequest request) {
        request = beforeClientExecution(request);
        return executeGetTransitGatewayRouteTablePropagations(request);
    }

    @SdkInternalApi
    final GetTransitGatewayRouteTablePropagationsResult executeGetTransitGatewayRouteTablePropagations(
            GetTransitGatewayRouteTablePropagationsRequest getTransitGatewayRouteTablePropagationsRequest) {

        ExecutionContext executionContext = createExecutionContext(getTransitGatewayRouteTablePropagationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTransitGatewayRouteTablePropagationsRequest> request = null;
        Response<GetTransitGatewayRouteTablePropagationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTransitGatewayRouteTablePropagationsRequestMarshaller().marshall(super
                        .beforeMarshalling(getTransitGatewayRouteTablePropagationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetTransitGatewayRouteTablePropagations");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<GetTransitGatewayRouteTablePropagationsResult> responseHandler = new StaxResponseHandler<GetTransitGatewayRouteTablePropagationsResult>(
                    new GetTransitGatewayRouteTablePropagationsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Import single or multi-volume disk images or EBS snapshots into an Amazon Machine Image (AMI). For more
     * information, see <a
     * href="http://docs.aws.amazon.com/vm-import/latest/userguide/vmimport-image-import.html">Importing a VM as an
     * Image Using VM Import/Export</a> in the <i>VM Import/Export User Guide</i>.
     * </p>
     * 
     * @param importImageRequest
     *        Contains the parameters for ImportImage.
     * @return Result of the ImportImage operation returned by the service.
     * @sample AmazonEC2.ImportImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ImportImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ImportImageResult importImage(ImportImageRequest request) {
        request = beforeClientExecution(request);
        return executeImportImage(request);
    }

    @SdkInternalApi
    final ImportImageResult executeImportImage(ImportImageRequest importImageRequest) {

        ExecutionContext executionContext = createExecutionContext(importImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportImageRequest> request = null;
        Response<ImportImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportImageRequestMarshaller().marshall(super.beforeMarshalling(importImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ImportImageResult> responseHandler = new StaxResponseHandler<ImportImageResult>(new ImportImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public ImportImageResult importImage() {
        return importImage(new ImportImageRequest());
    }

    /**
     * <p>
     * Creates an import instance task using metadata from the specified disk image. <code>ImportInstance</code> only
     * supports single-volume VMs. To import multi-volume VMs, use <a>ImportImage</a>. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/CommandLineReference/ec2-cli-vmimport-export.html">Importing a
     * Virtual Machine Using the Amazon EC2 CLI</a>.
     * </p>
     * <p>
     * For information about the import manifest referenced by this API action, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/APIReference/manifest.html">VM Import Manifest</a>.
     * </p>
     * 
     * @param importInstanceRequest
     *        Contains the parameters for ImportInstance.
     * @return Result of the ImportInstance operation returned by the service.
     * @sample AmazonEC2.ImportInstance
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ImportInstance" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ImportInstanceResult importInstance(ImportInstanceRequest request) {
        request = beforeClientExecution(request);
        return executeImportInstance(request);
    }

    @SdkInternalApi
    final ImportInstanceResult executeImportInstance(ImportInstanceRequest importInstanceRequest) {

        ExecutionContext executionContext = createExecutionContext(importInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportInstanceRequest> request = null;
        Response<ImportInstanceResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportInstanceRequestMarshaller().marshall(super.beforeMarshalling(importInstanceRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportInstance");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ImportInstanceResult> responseHandler = new StaxResponseHandler<ImportInstanceResult>(
                    new ImportInstanceResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Imports the public key from an RSA key pair that you created with a third-party tool. Compare this with
     * <a>CreateKeyPair</a>, in which AWS creates the key pair and gives the keys to you (AWS keeps a copy of the public
     * key). With ImportKeyPair, you create the key pair and give AWS just the public key. The private key is never
     * transferred between you and AWS.
     * </p>
     * <p>
     * For more information about key pairs, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html">Key Pairs</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param importKeyPairRequest
     * @return Result of the ImportKeyPair operation returned by the service.
     * @sample AmazonEC2.ImportKeyPair
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ImportKeyPair" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ImportKeyPairResult importKeyPair(ImportKeyPairRequest request) {
        request = beforeClientExecution(request);
        return executeImportKeyPair(request);
    }

    @SdkInternalApi
    final ImportKeyPairResult executeImportKeyPair(ImportKeyPairRequest importKeyPairRequest) {

        ExecutionContext executionContext = createExecutionContext(importKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportKeyPairRequest> request = null;
        Response<ImportKeyPairResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportKeyPairRequestMarshaller().marshall(super.beforeMarshalling(importKeyPairRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportKeyPair");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ImportKeyPairResult> responseHandler = new StaxResponseHandler<ImportKeyPairResult>(new ImportKeyPairResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Imports a disk into an EBS snapshot.
     * </p>
     * 
     * @param importSnapshotRequest
     *        Contains the parameters for ImportSnapshot.
     * @return Result of the ImportSnapshot operation returned by the service.
     * @sample AmazonEC2.ImportSnapshot
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ImportSnapshot" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ImportSnapshotResult importSnapshot(ImportSnapshotRequest request) {
        request = beforeClientExecution(request);
        return executeImportSnapshot(request);
    }

    @SdkInternalApi
    final ImportSnapshotResult executeImportSnapshot(ImportSnapshotRequest importSnapshotRequest) {

        ExecutionContext executionContext = createExecutionContext(importSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportSnapshotRequest> request = null;
        Response<ImportSnapshotResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportSnapshotRequestMarshaller().marshall(super.beforeMarshalling(importSnapshotRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportSnapshot");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ImportSnapshotResult> responseHandler = new StaxResponseHandler<ImportSnapshotResult>(
                    new ImportSnapshotResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    public ImportSnapshotResult importSnapshot() {
        return importSnapshot(new ImportSnapshotRequest());
    }

    /**
     * <p>
     * Creates an import volume task using metadata from the specified disk image.For more information, see <a href=
     * "http://docs.aws.amazon.com/AWSEC2/latest/CommandLineReference/importing-your-volumes-into-amazon-ebs.html"
     * >Importing Disks to Amazon EBS</a>.
     * </p>
     * <p>
     * For information about the import manifest referenced by this API action, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/APIReference/manifest.html">VM Import Manifest</a>.
     * </p>
     * 
     * @param importVolumeRequest
     *        Contains the parameters for ImportVolume.
     * @return Result of the ImportVolume operation returned by the service.
     * @sample AmazonEC2.ImportVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ImportVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ImportVolumeResult importVolume(ImportVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeImportVolume(request);
    }

    @SdkInternalApi
    final ImportVolumeResult executeImportVolume(ImportVolumeRequest importVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(importVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ImportVolumeRequest> request = null;
        Response<ImportVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ImportVolumeRequestMarshaller().marshall(super.beforeMarshalling(importVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ImportVolumeResult> responseHandler = new StaxResponseHandler<ImportVolumeResult>(new ImportVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies a Capacity Reservation's capacity and the conditions under which it is to be released. You cannot change
     * a Capacity Reservation's instance type, EBS optimization, instance store settings, platform, Availability Zone,
     * or instance eligibility. If you need to modify any of these attributes, we recommend that you cancel the Capacity
     * Reservation, and then create a new one with the required attributes.
     * </p>
     * 
     * @param modifyCapacityReservationRequest
     * @return Result of the ModifyCapacityReservation operation returned by the service.
     * @sample AmazonEC2.ModifyCapacityReservation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyCapacityReservation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifyCapacityReservationResult modifyCapacityReservation(ModifyCapacityReservationRequest request) {
        request = beforeClientExecution(request);
        return executeModifyCapacityReservation(request);
    }

    @SdkInternalApi
    final ModifyCapacityReservationResult executeModifyCapacityReservation(ModifyCapacityReservationRequest modifyCapacityReservationRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyCapacityReservationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyCapacityReservationRequest> request = null;
        Response<ModifyCapacityReservationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyCapacityReservationRequestMarshaller().marshall(super.beforeMarshalling(modifyCapacityReservationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyCapacityReservation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyCapacityReservationResult> responseHandler = new StaxResponseHandler<ModifyCapacityReservationResult>(
                    new ModifyCapacityReservationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified EC2 Fleet.
     * </p>
     * <p>
     * While the EC2 Fleet is being modified, it is in the <code>modifying</code> state.
     * </p>
     * 
     * @param modifyFleetRequest
     * @return Result of the ModifyFleet operation returned by the service.
     * @sample AmazonEC2.ModifyFleet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyFleet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyFleetResult modifyFleet(ModifyFleetRequest request) {
        request = beforeClientExecution(request);
        return executeModifyFleet(request);
    }

    @SdkInternalApi
    final ModifyFleetResult executeModifyFleet(ModifyFleetRequest modifyFleetRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyFleetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyFleetRequest> request = null;
        Response<ModifyFleetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyFleetRequestMarshaller().marshall(super.beforeMarshalling(modifyFleetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyFleet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyFleetResult> responseHandler = new StaxResponseHandler<ModifyFleetResult>(new ModifyFleetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified attribute of the specified Amazon FPGA Image (AFI).
     * </p>
     * 
     * @param modifyFpgaImageAttributeRequest
     * @return Result of the ModifyFpgaImageAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyFpgaImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyFpgaImageAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifyFpgaImageAttributeResult modifyFpgaImageAttribute(ModifyFpgaImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyFpgaImageAttribute(request);
    }

    @SdkInternalApi
    final ModifyFpgaImageAttributeResult executeModifyFpgaImageAttribute(ModifyFpgaImageAttributeRequest modifyFpgaImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyFpgaImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyFpgaImageAttributeRequest> request = null;
        Response<ModifyFpgaImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyFpgaImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyFpgaImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyFpgaImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyFpgaImageAttributeResult> responseHandler = new StaxResponseHandler<ModifyFpgaImageAttributeResult>(
                    new ModifyFpgaImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modify the auto-placement setting of a Dedicated Host. When auto-placement is enabled, any instances that you
     * launch with a tenancy of <code>host</code> but without a specific host ID are placed onto any available Dedicated
     * Host in your account that has auto-placement enabled. When auto-placement is disabled, you need to provide a host
     * ID to have the instance launch onto a specific host. If no host ID is provided, the instance is launched onto a
     * suitable host with auto-placement enabled.
     * </p>
     * 
     * @param modifyHostsRequest
     * @return Result of the ModifyHosts operation returned by the service.
     * @sample AmazonEC2.ModifyHosts
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyHosts" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyHostsResult modifyHosts(ModifyHostsRequest request) {
        request = beforeClientExecution(request);
        return executeModifyHosts(request);
    }

    @SdkInternalApi
    final ModifyHostsResult executeModifyHosts(ModifyHostsRequest modifyHostsRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyHostsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyHostsRequest> request = null;
        Response<ModifyHostsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyHostsRequestMarshaller().marshall(super.beforeMarshalling(modifyHostsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyHosts");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyHostsResult> responseHandler = new StaxResponseHandler<ModifyHostsResult>(new ModifyHostsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the ID format for the specified resource on a per-region basis. You can specify that resources should
     * receive longer IDs (17-character IDs) when they are created.
     * </p>
     * <p>
     * This request can only be used to modify longer ID settings for resource types that are within the opt-in period.
     * Resources currently in their opt-in period include: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>route-table</code> | <code>route-table-association</code> |
     * <code>security-group</code> | <code>subnet</code> | <code>subnet-cidr-block-association</code> | <code>vpc</code>
     * | <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * <p>
     * This setting applies to the IAM user who makes the request; it does not apply to the entire AWS account. By
     * default, an IAM user defaults to the same settings as the root user. If you're using this action as the root
     * user, then these settings apply to the entire account, unless an IAM user explicitly overrides these settings for
     * themselves. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/resource-ids.html">Resource IDs</a> in the <i>Amazon
     * Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * Resources created with longer IDs are visible to all IAM roles and users, regardless of these settings and
     * provided that they have permission to use the relevant <code>Describe</code> command for the resource type.
     * </p>
     * 
     * @param modifyIdFormatRequest
     * @return Result of the ModifyIdFormat operation returned by the service.
     * @sample AmazonEC2.ModifyIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyIdFormat" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyIdFormatResult modifyIdFormat(ModifyIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeModifyIdFormat(request);
    }

    @SdkInternalApi
    final ModifyIdFormatResult executeModifyIdFormat(ModifyIdFormatRequest modifyIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyIdFormatRequest> request = null;
        Response<ModifyIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyIdFormatRequestMarshaller().marshall(super.beforeMarshalling(modifyIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyIdFormatResult> responseHandler = new StaxResponseHandler<ModifyIdFormatResult>(
                    new ModifyIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the ID format of a resource for a specified IAM user, IAM role, or the root user for an account; or all
     * IAM users, IAM roles, and the root user for an account. You can specify that resources should receive longer IDs
     * (17-character IDs) when they are created.
     * </p>
     * <p>
     * This request can only be used to modify longer ID settings for resource types that are within the opt-in period.
     * Resources currently in their opt-in period include: <code>bundle</code> | <code>conversion-task</code> |
     * <code>customer-gateway</code> | <code>dhcp-options</code> | <code>elastic-ip-allocation</code> |
     * <code>elastic-ip-association</code> | <code>export-task</code> | <code>flow-log</code> | <code>image</code> |
     * <code>import-task</code> | <code>internet-gateway</code> | <code>network-acl</code> |
     * <code>network-acl-association</code> | <code>network-interface</code> | <code>network-interface-attachment</code>
     * | <code>prefix-list</code> | <code>route-table</code> | <code>route-table-association</code> |
     * <code>security-group</code> | <code>subnet</code> | <code>subnet-cidr-block-association</code> | <code>vpc</code>
     * | <code>vpc-cidr-block-association</code> | <code>vpc-endpoint</code> | <code>vpc-peering-connection</code> |
     * <code>vpn-connection</code> | <code>vpn-gateway</code>.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/resource-ids.html">Resource
     * IDs</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * This setting applies to the principal specified in the request; it does not apply to the principal that makes the
     * request.
     * </p>
     * <p>
     * Resources created with longer IDs are visible to all IAM roles and users, regardless of these settings and
     * provided that they have permission to use the relevant <code>Describe</code> command for the resource type.
     * </p>
     * 
     * @param modifyIdentityIdFormatRequest
     * @return Result of the ModifyIdentityIdFormat operation returned by the service.
     * @sample AmazonEC2.ModifyIdentityIdFormat
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyIdentityIdFormat" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyIdentityIdFormatResult modifyIdentityIdFormat(ModifyIdentityIdFormatRequest request) {
        request = beforeClientExecution(request);
        return executeModifyIdentityIdFormat(request);
    }

    @SdkInternalApi
    final ModifyIdentityIdFormatResult executeModifyIdentityIdFormat(ModifyIdentityIdFormatRequest modifyIdentityIdFormatRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyIdentityIdFormatRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyIdentityIdFormatRequest> request = null;
        Response<ModifyIdentityIdFormatResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyIdentityIdFormatRequestMarshaller().marshall(super.beforeMarshalling(modifyIdentityIdFormatRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyIdentityIdFormat");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyIdentityIdFormatResult> responseHandler = new StaxResponseHandler<ModifyIdentityIdFormatResult>(
                    new ModifyIdentityIdFormatResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified attribute of the specified AMI. You can specify only one attribute at a time. You can use
     * the <code>Attribute</code> parameter to specify the attribute or one of the following parameters:
     * <code>Description</code>, <code>LaunchPermission</code>, or <code>ProductCode</code>.
     * </p>
     * <p>
     * AWS Marketplace product codes cannot be modified. Images with an AWS Marketplace product code cannot be made
     * public.
     * </p>
     * <p>
     * To enable the SriovNetSupport enhanced networking attribute of an image, enable SriovNetSupport on an instance
     * and create an AMI from the instance.
     * </p>
     * 
     * @param modifyImageAttributeRequest
     *        Contains the parameters for ModifyImageAttribute.
     * @return Result of the ModifyImageAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyImageAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyImageAttributeResult modifyImageAttribute(ModifyImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyImageAttribute(request);
    }

    @SdkInternalApi
    final ModifyImageAttributeResult executeModifyImageAttribute(ModifyImageAttributeRequest modifyImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyImageAttributeRequest> request = null;
        Response<ModifyImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyImageAttributeResult> responseHandler = new StaxResponseHandler<ModifyImageAttributeResult>(
                    new ModifyImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified attribute of the specified instance. You can specify only one attribute at a time.
     * </p>
     * <p>
     * <b>Note: </b>Using this action to change the security groups associated with an elastic network interface (ENI)
     * attached to an instance in a VPC can result in an error if the instance has more than one ENI. To change the
     * security groups associated with an ENI attached to an instance that has multiple ENIs, we recommend that you use
     * the <a>ModifyNetworkInterfaceAttribute</a> action.
     * </p>
     * <p>
     * To modify some attributes, the instance must be stopped. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_ChangingAttributesWhileInstanceStopped.html"
     * >Modifying Attributes of a Stopped Instance</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param modifyInstanceAttributeRequest
     *        Contains the parameters for ModifyInstanceAttribute.
     * @return Result of the ModifyInstanceAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyInstanceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyInstanceAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifyInstanceAttributeResult modifyInstanceAttribute(ModifyInstanceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyInstanceAttribute(request);
    }

    @SdkInternalApi
    final ModifyInstanceAttributeResult executeModifyInstanceAttribute(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyInstanceAttributeRequest> request = null;
        Response<ModifyInstanceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyInstanceAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyInstanceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstanceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyInstanceAttributeResult> responseHandler = new StaxResponseHandler<ModifyInstanceAttributeResult>(
                    new ModifyInstanceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the Capacity Reservation settings for a stopped instance. Use this action to configure an instance to
     * target a specific Capacity Reservation, run in any <code>open</code> Capacity Reservation with matching
     * attributes, or run On-Demand Instance capacity.
     * </p>
     * 
     * @param modifyInstanceCapacityReservationAttributesRequest
     * @return Result of the ModifyInstanceCapacityReservationAttributes operation returned by the service.
     * @sample AmazonEC2.ModifyInstanceCapacityReservationAttributes
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyInstanceCapacityReservationAttributes"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyInstanceCapacityReservationAttributesResult modifyInstanceCapacityReservationAttributes(
            ModifyInstanceCapacityReservationAttributesRequest request) {
        request = beforeClientExecution(request);
        return executeModifyInstanceCapacityReservationAttributes(request);
    }

    @SdkInternalApi
    final ModifyInstanceCapacityReservationAttributesResult executeModifyInstanceCapacityReservationAttributes(
            ModifyInstanceCapacityReservationAttributesRequest modifyInstanceCapacityReservationAttributesRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyInstanceCapacityReservationAttributesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyInstanceCapacityReservationAttributesRequest> request = null;
        Response<ModifyInstanceCapacityReservationAttributesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyInstanceCapacityReservationAttributesRequestMarshaller().marshall(super
                        .beforeMarshalling(modifyInstanceCapacityReservationAttributesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstanceCapacityReservationAttributes");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyInstanceCapacityReservationAttributesResult> responseHandler = new StaxResponseHandler<ModifyInstanceCapacityReservationAttributesResult>(
                    new ModifyInstanceCapacityReservationAttributesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the credit option for CPU usage on a running or stopped T2 or T3 instance. The credit options are
     * <code>standard</code> and <code>unlimited</code>.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/burstable-performance-instances.html">Burstable
     * Performance Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param modifyInstanceCreditSpecificationRequest
     * @return Result of the ModifyInstanceCreditSpecification operation returned by the service.
     * @sample AmazonEC2.ModifyInstanceCreditSpecification
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyInstanceCreditSpecification"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyInstanceCreditSpecificationResult modifyInstanceCreditSpecification(ModifyInstanceCreditSpecificationRequest request) {
        request = beforeClientExecution(request);
        return executeModifyInstanceCreditSpecification(request);
    }

    @SdkInternalApi
    final ModifyInstanceCreditSpecificationResult executeModifyInstanceCreditSpecification(
            ModifyInstanceCreditSpecificationRequest modifyInstanceCreditSpecificationRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyInstanceCreditSpecificationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyInstanceCreditSpecificationRequest> request = null;
        Response<ModifyInstanceCreditSpecificationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyInstanceCreditSpecificationRequestMarshaller().marshall(super.beforeMarshalling(modifyInstanceCreditSpecificationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstanceCreditSpecification");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyInstanceCreditSpecificationResult> responseHandler = new StaxResponseHandler<ModifyInstanceCreditSpecificationResult>(
                    new ModifyInstanceCreditSpecificationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the placement attributes for a specified instance. You can do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Modify the affinity between an instance and a <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html">Dedicated Host</a>. When
     * affinity is set to <code>host</code> and the instance is not associated with a specific Dedicated Host, the next
     * time the instance is launched, it is automatically associated with the host on which it lands. If the instance is
     * restarted or rebooted, this relationship persists.
     * </p>
     * </li>
     * <li>
     * <p>
     * Change the Dedicated Host with which an instance is associated.
     * </p>
     * </li>
     * <li>
     * <p>
     * Change the instance tenancy of an instance from <code>host</code> to <code>dedicated</code>, or from
     * <code>dedicated</code> to <code>host</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * Move an instance to or from a <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html">placement group</a>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * At least one attribute for affinity, host ID, tenancy, or placement group name must be specified in the request.
     * Affinity and tenancy can be modified in the same request.
     * </p>
     * <p>
     * To modify the host ID, tenancy, or placement group for an instance, the instance must be in the
     * <code>stopped</code> state.
     * </p>
     * 
     * @param modifyInstancePlacementRequest
     * @return Result of the ModifyInstancePlacement operation returned by the service.
     * @sample AmazonEC2.ModifyInstancePlacement
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyInstancePlacement" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifyInstancePlacementResult modifyInstancePlacement(ModifyInstancePlacementRequest request) {
        request = beforeClientExecution(request);
        return executeModifyInstancePlacement(request);
    }

    @SdkInternalApi
    final ModifyInstancePlacementResult executeModifyInstancePlacement(ModifyInstancePlacementRequest modifyInstancePlacementRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyInstancePlacementRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyInstancePlacementRequest> request = null;
        Response<ModifyInstancePlacementResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyInstancePlacementRequestMarshaller().marshall(super.beforeMarshalling(modifyInstancePlacementRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyInstancePlacement");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyInstancePlacementResult> responseHandler = new StaxResponseHandler<ModifyInstancePlacementResult>(
                    new ModifyInstancePlacementResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies a launch template. You can specify which version of the launch template to set as the default version.
     * When launching an instance, the default version applies when a launch template version is not specified.
     * </p>
     * 
     * @param modifyLaunchTemplateRequest
     * @return Result of the ModifyLaunchTemplate operation returned by the service.
     * @sample AmazonEC2.ModifyLaunchTemplate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyLaunchTemplate" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyLaunchTemplateResult modifyLaunchTemplate(ModifyLaunchTemplateRequest request) {
        request = beforeClientExecution(request);
        return executeModifyLaunchTemplate(request);
    }

    @SdkInternalApi
    final ModifyLaunchTemplateResult executeModifyLaunchTemplate(ModifyLaunchTemplateRequest modifyLaunchTemplateRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyLaunchTemplateRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyLaunchTemplateRequest> request = null;
        Response<ModifyLaunchTemplateResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyLaunchTemplateRequestMarshaller().marshall(super.beforeMarshalling(modifyLaunchTemplateRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyLaunchTemplate");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyLaunchTemplateResult> responseHandler = new StaxResponseHandler<ModifyLaunchTemplateResult>(
                    new ModifyLaunchTemplateResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified network interface attribute. You can specify only one attribute at a time.
     * </p>
     * 
     * @param modifyNetworkInterfaceAttributeRequest
     *        Contains the parameters for ModifyNetworkInterfaceAttribute.
     * @return Result of the ModifyNetworkInterfaceAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyNetworkInterfaceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyNetworkInterfaceAttribute"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyNetworkInterfaceAttributeResult modifyNetworkInterfaceAttribute(ModifyNetworkInterfaceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyNetworkInterfaceAttribute(request);
    }

    @SdkInternalApi
    final ModifyNetworkInterfaceAttributeResult executeModifyNetworkInterfaceAttribute(
            ModifyNetworkInterfaceAttributeRequest modifyNetworkInterfaceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyNetworkInterfaceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyNetworkInterfaceAttributeRequest> request = null;
        Response<ModifyNetworkInterfaceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyNetworkInterfaceAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyNetworkInterfaceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyNetworkInterfaceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyNetworkInterfaceAttributeResult> responseHandler = new StaxResponseHandler<ModifyNetworkInterfaceAttributeResult>(
                    new ModifyNetworkInterfaceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the Availability Zone, instance count, instance type, or network platform (EC2-Classic or EC2-VPC) of
     * your Reserved Instances. The Reserved Instances to be modified must be identical, except for Availability Zone,
     * network platform, and instance type.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-modifying.html">Modifying Reserved Instances</a> in
     * the Amazon Elastic Compute Cloud User Guide.
     * </p>
     * 
     * @param modifyReservedInstancesRequest
     *        Contains the parameters for ModifyReservedInstances.
     * @return Result of the ModifyReservedInstances operation returned by the service.
     * @sample AmazonEC2.ModifyReservedInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyReservedInstances" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifyReservedInstancesResult modifyReservedInstances(ModifyReservedInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeModifyReservedInstances(request);
    }

    @SdkInternalApi
    final ModifyReservedInstancesResult executeModifyReservedInstances(ModifyReservedInstancesRequest modifyReservedInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyReservedInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyReservedInstancesRequest> request = null;
        Response<ModifyReservedInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyReservedInstancesRequestMarshaller().marshall(super.beforeMarshalling(modifyReservedInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyReservedInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyReservedInstancesResult> responseHandler = new StaxResponseHandler<ModifyReservedInstancesResult>(
                    new ModifyReservedInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Adds or removes permission settings for the specified snapshot. You may add or remove specified AWS account IDs
     * from a snapshot's list of create volume permissions, but you cannot do both in a single API call. If you need to
     * both add and remove account IDs for a snapshot, you must use multiple API calls.
     * </p>
     * <p>
     * Encrypted snapshots and snapshots with AWS Marketplace product codes cannot be made public. Snapshots encrypted
     * with your default CMK cannot be shared with other accounts.
     * </p>
     * <p>
     * For more information about modifying snapshot permissions, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-modifying-snapshot-permissions.html">Sharing
     * Snapshots</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param modifySnapshotAttributeRequest
     *        Contains the parameters for ModifySnapshotAttribute.
     * @return Result of the ModifySnapshotAttribute operation returned by the service.
     * @sample AmazonEC2.ModifySnapshotAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifySnapshotAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ModifySnapshotAttributeResult modifySnapshotAttribute(ModifySnapshotAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifySnapshotAttribute(request);
    }

    @SdkInternalApi
    final ModifySnapshotAttributeResult executeModifySnapshotAttribute(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifySnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifySnapshotAttributeRequest> request = null;
        Response<ModifySnapshotAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifySnapshotAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifySnapshotAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifySnapshotAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifySnapshotAttributeResult> responseHandler = new StaxResponseHandler<ModifySnapshotAttributeResult>(
                    new ModifySnapshotAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified Spot Fleet request.
     * </p>
     * <p>
     * While the Spot Fleet request is being modified, it is in the <code>modifying</code> state.
     * </p>
     * <p>
     * To scale up your Spot Fleet, increase its target capacity. The Spot Fleet launches the additional Spot Instances
     * according to the allocation strategy for the Spot Fleet request. If the allocation strategy is
     * <code>lowestPrice</code>, the Spot Fleet launches instances using the Spot pool with the lowest price. If the
     * allocation strategy is <code>diversified</code>, the Spot Fleet distributes the instances across the Spot pools.
     * </p>
     * <p>
     * To scale down your Spot Fleet, decrease its target capacity. First, the Spot Fleet cancels any open requests that
     * exceed the new target capacity. You can request that the Spot Fleet terminate Spot Instances until the size of
     * the fleet no longer exceeds the new target capacity. If the allocation strategy is <code>lowestPrice</code>, the
     * Spot Fleet terminates the instances with the highest price per unit. If the allocation strategy is
     * <code>diversified</code>, the Spot Fleet terminates instances across the Spot pools. Alternatively, you can
     * request that the Spot Fleet keep the fleet at its current size, but not replace any Spot Instances that are
     * interrupted or that you terminate manually.
     * </p>
     * <p>
     * If you are finished with your Spot Fleet for now, but will use it again later, you can set the target capacity to
     * 0.
     * </p>
     * 
     * @param modifySpotFleetRequestRequest
     *        Contains the parameters for ModifySpotFleetRequest.
     * @return Result of the ModifySpotFleetRequest operation returned by the service.
     * @sample AmazonEC2.ModifySpotFleetRequest
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifySpotFleetRequest" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifySpotFleetRequestResult modifySpotFleetRequest(ModifySpotFleetRequestRequest request) {
        request = beforeClientExecution(request);
        return executeModifySpotFleetRequest(request);
    }

    @SdkInternalApi
    final ModifySpotFleetRequestResult executeModifySpotFleetRequest(ModifySpotFleetRequestRequest modifySpotFleetRequestRequest) {

        ExecutionContext executionContext = createExecutionContext(modifySpotFleetRequestRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifySpotFleetRequestRequest> request = null;
        Response<ModifySpotFleetRequestResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifySpotFleetRequestRequestMarshaller().marshall(super.beforeMarshalling(modifySpotFleetRequestRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifySpotFleetRequest");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifySpotFleetRequestResult> responseHandler = new StaxResponseHandler<ModifySpotFleetRequestResult>(
                    new ModifySpotFleetRequestResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies a subnet attribute. You can only modify one attribute at a time.
     * </p>
     * 
     * @param modifySubnetAttributeRequest
     * @return Result of the ModifySubnetAttribute operation returned by the service.
     * @sample AmazonEC2.ModifySubnetAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifySubnetAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifySubnetAttributeResult modifySubnetAttribute(ModifySubnetAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifySubnetAttribute(request);
    }

    @SdkInternalApi
    final ModifySubnetAttributeResult executeModifySubnetAttribute(ModifySubnetAttributeRequest modifySubnetAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifySubnetAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifySubnetAttributeRequest> request = null;
        Response<ModifySubnetAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifySubnetAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifySubnetAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifySubnetAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifySubnetAttributeResult> responseHandler = new StaxResponseHandler<ModifySubnetAttributeResult>(
                    new ModifySubnetAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified VPC attachment.
     * </p>
     * 
     * @param modifyTransitGatewayVpcAttachmentRequest
     * @return Result of the ModifyTransitGatewayVpcAttachment operation returned by the service.
     * @sample AmazonEC2.ModifyTransitGatewayVpcAttachment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyTransitGatewayVpcAttachment"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyTransitGatewayVpcAttachmentResult modifyTransitGatewayVpcAttachment(ModifyTransitGatewayVpcAttachmentRequest request) {
        request = beforeClientExecution(request);
        return executeModifyTransitGatewayVpcAttachment(request);
    }

    @SdkInternalApi
    final ModifyTransitGatewayVpcAttachmentResult executeModifyTransitGatewayVpcAttachment(
            ModifyTransitGatewayVpcAttachmentRequest modifyTransitGatewayVpcAttachmentRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyTransitGatewayVpcAttachmentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyTransitGatewayVpcAttachmentRequest> request = null;
        Response<ModifyTransitGatewayVpcAttachmentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyTransitGatewayVpcAttachmentRequestMarshaller().marshall(super.beforeMarshalling(modifyTransitGatewayVpcAttachmentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyTransitGatewayVpcAttachment");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyTransitGatewayVpcAttachmentResult> responseHandler = new StaxResponseHandler<ModifyTransitGatewayVpcAttachmentResult>(
                    new ModifyTransitGatewayVpcAttachmentResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * You can modify several parameters of an existing EBS volume, including volume size, volume type, and IOPS
     * capacity. If your EBS volume is attached to a current-generation EC2 instance type, you may be able to apply
     * these changes without stopping the instance or detaching the volume from it. For more information about modifying
     * an EBS volume running Linux, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html">Modifying the Size, IOPS, or
     * Type of an EBS Volume on Linux</a>. For more information about modifying an EBS volume running Windows, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ebs-expand-volume.html">Modifying the Size, IOPS, or
     * Type of an EBS Volume on Windows</a>.
     * </p>
     * <p>
     * When you complete a resize operation on your volume, you need to extend the volume's file-system size to take
     * advantage of the new storage capacity. For information about extending a Linux file system, see <a href=
     * "http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html#recognize-expanded-volume-linux"
     * >Extending a Linux File System</a>. For information about extending a Windows file system, see <a href=
     * "http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ebs-expand-volume.html#recognize-expanded-volume-windows"
     * >Extending a Windows File System</a>.
     * </p>
     * <p>
     * You can use CloudWatch Events to check the status of a modification to an EBS volume. For information about
     * CloudWatch Events, see the <a href="http://docs.aws.amazon.com/AmazonCloudWatch/latest/events/">Amazon CloudWatch
     * Events User Guide</a>. You can also track the status of a modification using the
     * <a>DescribeVolumesModifications</a> API. For information about tracking status changes using either method, see
     * <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html#monitoring_mods">Monitoring
     * Volume Modifications</a>.
     * </p>
     * <p>
     * With previous-generation instance types, resizing an EBS volume may require detaching and reattaching the volume
     * or stopping and restarting the instance. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html">Modifying the Size, IOPS, or
     * Type of an EBS Volume on Linux</a> and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ebs-expand-volume.html">Modifying the Size, IOPS, or
     * Type of an EBS Volume on Windows</a>.
     * </p>
     * <p>
     * If you reach the maximum volume modification rate per volume limit, you will need to wait at least six hours
     * before applying further modifications to the affected EBS volume.
     * </p>
     * 
     * @param modifyVolumeRequest
     * @return Result of the ModifyVolume operation returned by the service.
     * @sample AmazonEC2.ModifyVolume
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVolume" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyVolumeResult modifyVolume(ModifyVolumeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVolume(request);
    }

    @SdkInternalApi
    final ModifyVolumeResult executeModifyVolume(ModifyVolumeRequest modifyVolumeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVolumeRequest> request = null;
        Response<ModifyVolumeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVolumeRequestMarshaller().marshall(super.beforeMarshalling(modifyVolumeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVolume");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVolumeResult> responseHandler = new StaxResponseHandler<ModifyVolumeResult>(new ModifyVolumeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies a volume attribute.
     * </p>
     * <p>
     * By default, all I/O operations for the volume are suspended when the data on the volume is determined to be
     * potentially inconsistent, to prevent undetectable, latent data corruption. The I/O access to the volume can be
     * resumed by first enabling I/O access and then checking the data consistency on your volume.
     * </p>
     * <p>
     * You can change the default behavior to resume I/O operations. We recommend that you change this only for boot
     * volumes or for volumes that are stateless or disposable.
     * </p>
     * 
     * @param modifyVolumeAttributeRequest
     *        Contains the parameters for ModifyVolumeAttribute.
     * @return Result of the ModifyVolumeAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyVolumeAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVolumeAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyVolumeAttributeResult modifyVolumeAttribute(ModifyVolumeAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVolumeAttribute(request);
    }

    @SdkInternalApi
    final ModifyVolumeAttributeResult executeModifyVolumeAttribute(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVolumeAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVolumeAttributeRequest> request = null;
        Response<ModifyVolumeAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVolumeAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyVolumeAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVolumeAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVolumeAttributeResult> responseHandler = new StaxResponseHandler<ModifyVolumeAttributeResult>(
                    new ModifyVolumeAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the specified attribute of the specified VPC.
     * </p>
     * 
     * @param modifyVpcAttributeRequest
     * @return Result of the ModifyVpcAttribute operation returned by the service.
     * @sample AmazonEC2.ModifyVpcAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyVpcAttributeResult modifyVpcAttribute(ModifyVpcAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcAttribute(request);
    }

    @SdkInternalApi
    final ModifyVpcAttributeResult executeModifyVpcAttribute(ModifyVpcAttributeRequest modifyVpcAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcAttributeRequest> request = null;
        Response<ModifyVpcAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcAttributeRequestMarshaller().marshall(super.beforeMarshalling(modifyVpcAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcAttributeResult> responseHandler = new StaxResponseHandler<ModifyVpcAttributeResult>(
                    new ModifyVpcAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies attributes of a specified VPC endpoint. The attributes that you can modify depend on the type of VPC
     * endpoint (interface or gateway). For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/vpc-endpoints.html">VPC Endpoints</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param modifyVpcEndpointRequest
     *        Contains the parameters for ModifyVpcEndpoint.
     * @return Result of the ModifyVpcEndpoint operation returned by the service.
     * @sample AmazonEC2.ModifyVpcEndpoint
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcEndpoint" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyVpcEndpointResult modifyVpcEndpoint(ModifyVpcEndpointRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcEndpoint(request);
    }

    @SdkInternalApi
    final ModifyVpcEndpointResult executeModifyVpcEndpoint(ModifyVpcEndpointRequest modifyVpcEndpointRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcEndpointRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcEndpointRequest> request = null;
        Response<ModifyVpcEndpointResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcEndpointRequestMarshaller().marshall(super.beforeMarshalling(modifyVpcEndpointRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcEndpoint");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcEndpointResult> responseHandler = new StaxResponseHandler<ModifyVpcEndpointResult>(
                    new ModifyVpcEndpointResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies a connection notification for VPC endpoint or VPC endpoint service. You can change the SNS topic for the
     * notification, or the events for which to be notified.
     * </p>
     * 
     * @param modifyVpcEndpointConnectionNotificationRequest
     * @return Result of the ModifyVpcEndpointConnectionNotification operation returned by the service.
     * @sample AmazonEC2.ModifyVpcEndpointConnectionNotification
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcEndpointConnectionNotification"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyVpcEndpointConnectionNotificationResult modifyVpcEndpointConnectionNotification(ModifyVpcEndpointConnectionNotificationRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcEndpointConnectionNotification(request);
    }

    @SdkInternalApi
    final ModifyVpcEndpointConnectionNotificationResult executeModifyVpcEndpointConnectionNotification(
            ModifyVpcEndpointConnectionNotificationRequest modifyVpcEndpointConnectionNotificationRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcEndpointConnectionNotificationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcEndpointConnectionNotificationRequest> request = null;
        Response<ModifyVpcEndpointConnectionNotificationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcEndpointConnectionNotificationRequestMarshaller().marshall(super
                        .beforeMarshalling(modifyVpcEndpointConnectionNotificationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcEndpointConnectionNotification");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcEndpointConnectionNotificationResult> responseHandler = new StaxResponseHandler<ModifyVpcEndpointConnectionNotificationResult>(
                    new ModifyVpcEndpointConnectionNotificationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the attributes of your VPC endpoint service configuration. You can change the Network Load Balancers for
     * your service, and you can specify whether acceptance is required for requests to connect to your endpoint service
     * through an interface VPC endpoint.
     * </p>
     * 
     * @param modifyVpcEndpointServiceConfigurationRequest
     * @return Result of the ModifyVpcEndpointServiceConfiguration operation returned by the service.
     * @sample AmazonEC2.ModifyVpcEndpointServiceConfiguration
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcEndpointServiceConfiguration"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyVpcEndpointServiceConfigurationResult modifyVpcEndpointServiceConfiguration(ModifyVpcEndpointServiceConfigurationRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcEndpointServiceConfiguration(request);
    }

    @SdkInternalApi
    final ModifyVpcEndpointServiceConfigurationResult executeModifyVpcEndpointServiceConfiguration(
            ModifyVpcEndpointServiceConfigurationRequest modifyVpcEndpointServiceConfigurationRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcEndpointServiceConfigurationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcEndpointServiceConfigurationRequest> request = null;
        Response<ModifyVpcEndpointServiceConfigurationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcEndpointServiceConfigurationRequestMarshaller().marshall(super
                        .beforeMarshalling(modifyVpcEndpointServiceConfigurationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcEndpointServiceConfiguration");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcEndpointServiceConfigurationResult> responseHandler = new StaxResponseHandler<ModifyVpcEndpointServiceConfigurationResult>(
                    new ModifyVpcEndpointServiceConfigurationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the permissions for your <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/endpoint-service.html">VPC endpoint service</a>. You
     * can add or remove permissions for service consumers (IAM users, IAM roles, and AWS accounts) to connect to your
     * endpoint service.
     * </p>
     * <p>
     * If you grant permissions to all principals, the service is public. Any users who know the name of a public
     * service can send a request to attach an endpoint. If the service does not require manual approval, attachments
     * are automatically approved.
     * </p>
     * 
     * @param modifyVpcEndpointServicePermissionsRequest
     * @return Result of the ModifyVpcEndpointServicePermissions operation returned by the service.
     * @sample AmazonEC2.ModifyVpcEndpointServicePermissions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcEndpointServicePermissions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyVpcEndpointServicePermissionsResult modifyVpcEndpointServicePermissions(ModifyVpcEndpointServicePermissionsRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcEndpointServicePermissions(request);
    }

    @SdkInternalApi
    final ModifyVpcEndpointServicePermissionsResult executeModifyVpcEndpointServicePermissions(
            ModifyVpcEndpointServicePermissionsRequest modifyVpcEndpointServicePermissionsRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcEndpointServicePermissionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcEndpointServicePermissionsRequest> request = null;
        Response<ModifyVpcEndpointServicePermissionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcEndpointServicePermissionsRequestMarshaller().marshall(super
                        .beforeMarshalling(modifyVpcEndpointServicePermissionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcEndpointServicePermissions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcEndpointServicePermissionsResult> responseHandler = new StaxResponseHandler<ModifyVpcEndpointServicePermissionsResult>(
                    new ModifyVpcEndpointServicePermissionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the VPC peering connection options on one side of a VPC peering connection. You can do the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Enable/disable communication over the peering connection between an EC2-Classic instance that's linked to your
     * VPC (using ClassicLink) and instances in the peer VPC.
     * </p>
     * </li>
     * <li>
     * <p>
     * Enable/disable communication over the peering connection between instances in your VPC and an EC2-Classic
     * instance that's linked to the peer VPC.
     * </p>
     * </li>
     * <li>
     * <p>
     * Enable/disable the ability to resolve public DNS hostnames to private IP addresses when queried from instances in
     * the peer VPC.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the peered VPCs are in the same AWS account, you can enable DNS resolution for queries from the local VPC.
     * This ensures that queries from the local VPC resolve to private IP addresses in the peer VPC. This option is not
     * available if the peered VPCs are in different AWS accounts or different regions. For peered VPCs in different AWS
     * accounts, each AWS account owner must initiate a separate request to modify the peering connection options. For
     * inter-region peering connections, you must use the region for the requester VPC to modify the requester VPC
     * peering options and the region for the accepter VPC to modify the accepter VPC peering options. To verify which
     * VPCs are the accepter and the requester for a VPC peering connection, use the
     * <a>DescribeVpcPeeringConnections</a> command.
     * </p>
     * 
     * @param modifyVpcPeeringConnectionOptionsRequest
     * @return Result of the ModifyVpcPeeringConnectionOptions operation returned by the service.
     * @sample AmazonEC2.ModifyVpcPeeringConnectionOptions
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcPeeringConnectionOptions"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ModifyVpcPeeringConnectionOptionsResult modifyVpcPeeringConnectionOptions(ModifyVpcPeeringConnectionOptionsRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcPeeringConnectionOptions(request);
    }

    @SdkInternalApi
    final ModifyVpcPeeringConnectionOptionsResult executeModifyVpcPeeringConnectionOptions(
            ModifyVpcPeeringConnectionOptionsRequest modifyVpcPeeringConnectionOptionsRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcPeeringConnectionOptionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcPeeringConnectionOptionsRequest> request = null;
        Response<ModifyVpcPeeringConnectionOptionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcPeeringConnectionOptionsRequestMarshaller().marshall(super.beforeMarshalling(modifyVpcPeeringConnectionOptionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcPeeringConnectionOptions");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcPeeringConnectionOptionsResult> responseHandler = new StaxResponseHandler<ModifyVpcPeeringConnectionOptionsResult>(
                    new ModifyVpcPeeringConnectionOptionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Modifies the instance tenancy attribute of the specified VPC. You can change the instance tenancy attribute of a
     * VPC to <code>default</code> only. You cannot change the instance tenancy attribute to <code>dedicated</code>.
     * </p>
     * <p>
     * After you modify the tenancy of the VPC, any new instances that you launch into the VPC have a tenancy of
     * <code>default</code>, unless you specify otherwise during launch. The tenancy of any existing instances in the
     * VPC is not affected.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-instance.html">Dedicated Instances</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param modifyVpcTenancyRequest
     * @return Result of the ModifyVpcTenancy operation returned by the service.
     * @sample AmazonEC2.ModifyVpcTenancy
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ModifyVpcTenancy" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ModifyVpcTenancyResult modifyVpcTenancy(ModifyVpcTenancyRequest request) {
        request = beforeClientExecution(request);
        return executeModifyVpcTenancy(request);
    }

    @SdkInternalApi
    final ModifyVpcTenancyResult executeModifyVpcTenancy(ModifyVpcTenancyRequest modifyVpcTenancyRequest) {

        ExecutionContext executionContext = createExecutionContext(modifyVpcTenancyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ModifyVpcTenancyRequest> request = null;
        Response<ModifyVpcTenancyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ModifyVpcTenancyRequestMarshaller().marshall(super.beforeMarshalling(modifyVpcTenancyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ModifyVpcTenancy");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ModifyVpcTenancyResult> responseHandler = new StaxResponseHandler<ModifyVpcTenancyResult>(
                    new ModifyVpcTenancyResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Enables detailed monitoring for a running instance. Otherwise, basic monitoring is enabled. For more information,
     * see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-cloudwatch.html">Monitoring Your Instances
     * and Volumes</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * To disable detailed monitoring, see .
     * </p>
     * 
     * @param monitorInstancesRequest
     *        Contains the parameters for MonitorInstances.
     * @return Result of the MonitorInstances operation returned by the service.
     * @sample AmazonEC2.MonitorInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/MonitorInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public MonitorInstancesResult monitorInstances(MonitorInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeMonitorInstances(request);
    }

    @SdkInternalApi
    final MonitorInstancesResult executeMonitorInstances(MonitorInstancesRequest monitorInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(monitorInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<MonitorInstancesRequest> request = null;
        Response<MonitorInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new MonitorInstancesRequestMarshaller().marshall(super.beforeMarshalling(monitorInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "MonitorInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<MonitorInstancesResult> responseHandler = new StaxResponseHandler<MonitorInstancesResult>(
                    new MonitorInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Moves an Elastic IP address from the EC2-Classic platform to the EC2-VPC platform. The Elastic IP address must be
     * allocated to your account for more than 24 hours, and it must not be associated with an instance. After the
     * Elastic IP address is moved, it is no longer available for use in the EC2-Classic platform, unless you move it
     * back using the <a>RestoreAddressToClassic</a> request. You cannot move an Elastic IP address that was originally
     * allocated for use in the EC2-VPC platform to the EC2-Classic platform.
     * </p>
     * 
     * @param moveAddressToVpcRequest
     * @return Result of the MoveAddressToVpc operation returned by the service.
     * @sample AmazonEC2.MoveAddressToVpc
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/MoveAddressToVpc" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public MoveAddressToVpcResult moveAddressToVpc(MoveAddressToVpcRequest request) {
        request = beforeClientExecution(request);
        return executeMoveAddressToVpc(request);
    }

    @SdkInternalApi
    final MoveAddressToVpcResult executeMoveAddressToVpc(MoveAddressToVpcRequest moveAddressToVpcRequest) {

        ExecutionContext executionContext = createExecutionContext(moveAddressToVpcRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<MoveAddressToVpcRequest> request = null;
        Response<MoveAddressToVpcResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new MoveAddressToVpcRequestMarshaller().marshall(super.beforeMarshalling(moveAddressToVpcRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "MoveAddressToVpc");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<MoveAddressToVpcResult> responseHandler = new StaxResponseHandler<MoveAddressToVpcResult>(
                    new MoveAddressToVpcResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Provisions an address range for use with your AWS resources through bring your own IP addresses (BYOIP) and
     * creates a corresponding address pool. After the address range is provisioned, it is ready to be advertised using
     * <a>AdvertiseByoipCidr</a>.
     * </p>
     * <p>
     * AWS verifies that you own the address range and are authorized to advertise it. You must ensure that the address
     * range is registered to you and that you created an RPKI ROA to authorize Amazon ASNs 16509 and 14618 to advertise
     * the address range. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-byoip.html">Bring Your Own IP Addresses (BYOIP)</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * Provisioning an address range is an asynchronous operation, so the call returns immediately, but the address
     * range is not ready to use until its status changes from <code>pending-provision</code> to
     * <code>provisioned</code>. To monitor the status of an address range, use <a>DescribeByoipCidrs</a>. To allocate
     * an Elastic IP address from your address pool, use <a>AllocateAddress</a> with either the specific address from
     * the address pool or the ID of the address pool.
     * </p>
     * 
     * @param provisionByoipCidrRequest
     * @return Result of the ProvisionByoipCidr operation returned by the service.
     * @sample AmazonEC2.ProvisionByoipCidr
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ProvisionByoipCidr" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ProvisionByoipCidrResult provisionByoipCidr(ProvisionByoipCidrRequest request) {
        request = beforeClientExecution(request);
        return executeProvisionByoipCidr(request);
    }

    @SdkInternalApi
    final ProvisionByoipCidrResult executeProvisionByoipCidr(ProvisionByoipCidrRequest provisionByoipCidrRequest) {

        ExecutionContext executionContext = createExecutionContext(provisionByoipCidrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ProvisionByoipCidrRequest> request = null;
        Response<ProvisionByoipCidrResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ProvisionByoipCidrRequestMarshaller().marshall(super.beforeMarshalling(provisionByoipCidrRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ProvisionByoipCidr");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ProvisionByoipCidrResult> responseHandler = new StaxResponseHandler<ProvisionByoipCidrResult>(
                    new ProvisionByoipCidrResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Purchase a reservation with configurations that match those of your Dedicated Host. You must have active
     * Dedicated Hosts in your account before you purchase a reservation. This action results in the specified
     * reservation being purchased and charged to your account.
     * </p>
     * 
     * @param purchaseHostReservationRequest
     * @return Result of the PurchaseHostReservation operation returned by the service.
     * @sample AmazonEC2.PurchaseHostReservation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/PurchaseHostReservation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public PurchaseHostReservationResult purchaseHostReservation(PurchaseHostReservationRequest request) {
        request = beforeClientExecution(request);
        return executePurchaseHostReservation(request);
    }

    @SdkInternalApi
    final PurchaseHostReservationResult executePurchaseHostReservation(PurchaseHostReservationRequest purchaseHostReservationRequest) {

        ExecutionContext executionContext = createExecutionContext(purchaseHostReservationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PurchaseHostReservationRequest> request = null;
        Response<PurchaseHostReservationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PurchaseHostReservationRequestMarshaller().marshall(super.beforeMarshalling(purchaseHostReservationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PurchaseHostReservation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<PurchaseHostReservationResult> responseHandler = new StaxResponseHandler<PurchaseHostReservationResult>(
                    new PurchaseHostReservationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Purchases a Reserved Instance for use with your account. With Reserved Instances, you pay a lower hourly rate
     * compared to On-Demand instance pricing.
     * </p>
     * <p>
     * Use <a>DescribeReservedInstancesOfferings</a> to get a list of Reserved Instance offerings that match your
     * specifications. After you've purchased a Reserved Instance, you can check for your new Reserved Instance with
     * <a>DescribeReservedInstances</a>.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts-on-demand-reserved-instances.html">Reserved
     * Instances</a> and <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-market-general.html">Reserved
     * Instance Marketplace</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param purchaseReservedInstancesOfferingRequest
     *        Contains the parameters for PurchaseReservedInstancesOffering.
     * @return Result of the PurchaseReservedInstancesOffering operation returned by the service.
     * @sample AmazonEC2.PurchaseReservedInstancesOffering
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/PurchaseReservedInstancesOffering"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOffering(PurchaseReservedInstancesOfferingRequest request) {
        request = beforeClientExecution(request);
        return executePurchaseReservedInstancesOffering(request);
    }

    @SdkInternalApi
    final PurchaseReservedInstancesOfferingResult executePurchaseReservedInstancesOffering(
            PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) {

        ExecutionContext executionContext = createExecutionContext(purchaseReservedInstancesOfferingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PurchaseReservedInstancesOfferingRequest> request = null;
        Response<PurchaseReservedInstancesOfferingResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PurchaseReservedInstancesOfferingRequestMarshaller().marshall(super.beforeMarshalling(purchaseReservedInstancesOfferingRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PurchaseReservedInstancesOffering");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<PurchaseReservedInstancesOfferingResult> responseHandler = new StaxResponseHandler<PurchaseReservedInstancesOfferingResult>(
                    new PurchaseReservedInstancesOfferingResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Purchases one or more Scheduled Instances with the specified schedule.
     * </p>
     * <p>
     * Scheduled Instances enable you to purchase Amazon EC2 compute capacity by the hour for a one-year term. Before
     * you can purchase a Scheduled Instance, you must call <a>DescribeScheduledInstanceAvailability</a> to check for
     * available schedules and obtain a purchase token. After you purchase a Scheduled Instance, you must call
     * <a>RunScheduledInstances</a> during each scheduled time period.
     * </p>
     * <p>
     * After you purchase a Scheduled Instance, you can't cancel, modify, or resell your purchase.
     * </p>
     * 
     * @param purchaseScheduledInstancesRequest
     *        Contains the parameters for PurchaseScheduledInstances.
     * @return Result of the PurchaseScheduledInstances operation returned by the service.
     * @sample AmazonEC2.PurchaseScheduledInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/PurchaseScheduledInstances" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public PurchaseScheduledInstancesResult purchaseScheduledInstances(PurchaseScheduledInstancesRequest request) {
        request = beforeClientExecution(request);
        return executePurchaseScheduledInstances(request);
    }

    @SdkInternalApi
    final PurchaseScheduledInstancesResult executePurchaseScheduledInstances(PurchaseScheduledInstancesRequest purchaseScheduledInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(purchaseScheduledInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PurchaseScheduledInstancesRequest> request = null;
        Response<PurchaseScheduledInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PurchaseScheduledInstancesRequestMarshaller().marshall(super.beforeMarshalling(purchaseScheduledInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PurchaseScheduledInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<PurchaseScheduledInstancesResult> responseHandler = new StaxResponseHandler<PurchaseScheduledInstancesResult>(
                    new PurchaseScheduledInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Requests a reboot of one or more instances. This operation is asynchronous; it only queues a request to reboot
     * the specified instances. The operation succeeds if the instances are valid and belong to you. Requests to reboot
     * terminated instances are ignored.
     * </p>
     * <p>
     * If an instance does not cleanly shut down within four minutes, Amazon EC2 performs a hard reboot.
     * </p>
     * <p>
     * For more information about troubleshooting, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-console.html">Getting Console Output and
     * Rebooting Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param rebootInstancesRequest
     *        Contains the parameters for RebootInstances.
     * @return Result of the RebootInstances operation returned by the service.
     * @sample AmazonEC2.RebootInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RebootInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RebootInstancesResult rebootInstances(RebootInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeRebootInstances(request);
    }

    @SdkInternalApi
    final RebootInstancesResult executeRebootInstances(RebootInstancesRequest rebootInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(rebootInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RebootInstancesRequest> request = null;
        Response<RebootInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RebootInstancesRequestMarshaller().marshall(super.beforeMarshalling(rebootInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RebootInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RebootInstancesResult> responseHandler = new StaxResponseHandler<RebootInstancesResult>(
                    new RebootInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Registers an AMI. When you're creating an AMI, this is the final step you must complete before you can launch an
     * instance from the AMI. For more information about creating AMIs, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami.html">Creating Your Own AMIs</a> in the
     * <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <note>
     * <p>
     * For Amazon EBS-backed instances, <a>CreateImage</a> creates and registers the AMI in a single request, so you
     * don't have to register the AMI yourself.
     * </p>
     * </note>
     * <p>
     * You can also use <code>RegisterImage</code> to create an Amazon EBS-backed Linux AMI from a snapshot of a root
     * device volume. You specify the snapshot using the block device mapping. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-launch-snapshot.html">Launching a Linux
     * Instance from a Backup</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * You can't register an image where a secondary (non-root) snapshot has AWS Marketplace product codes.
     * </p>
     * <p>
     * Some Linux distributions, such as Red Hat Enterprise Linux (RHEL) and SUSE Linux Enterprise Server (SLES), use
     * the EC2 billing product code associated with an AMI to verify the subscription status for package updates.
     * Creating an AMI from an EBS snapshot does not maintain this billing code, and instances launched from such an AMI
     * are not able to connect to package update infrastructure. If you purchase a Reserved Instance offering for one of
     * these Linux distributions and launch instances using an AMI that does not contain the required billing code, your
     * Reserved Instance is not applied to these instances.
     * </p>
     * <p>
     * To create an AMI for operating systems that require a billing code, see <a>CreateImage</a>.
     * </p>
     * <p>
     * If needed, you can deregister an AMI at any time. Any modifications you make to an AMI backed by an instance
     * store volume invalidates its registration. If you make changes to an image, deregister the previous image and
     * register the new image.
     * </p>
     * 
     * @param registerImageRequest
     *        Contains the parameters for RegisterImage.
     * @return Result of the RegisterImage operation returned by the service.
     * @sample AmazonEC2.RegisterImage
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RegisterImage" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RegisterImageResult registerImage(RegisterImageRequest request) {
        request = beforeClientExecution(request);
        return executeRegisterImage(request);
    }

    @SdkInternalApi
    final RegisterImageResult executeRegisterImage(RegisterImageRequest registerImageRequest) {

        ExecutionContext executionContext = createExecutionContext(registerImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterImageRequest> request = null;
        Response<RegisterImageResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterImageRequestMarshaller().marshall(super.beforeMarshalling(registerImageRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RegisterImage");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RegisterImageResult> responseHandler = new StaxResponseHandler<RegisterImageResult>(new RegisterImageResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Rejects a request to attach a VPC to a transit gateway.
     * </p>
     * <p>
     * The VPC attachment must be in the <code>pendingAcceptance</code> state. Use
     * <a>DescribeTransitGatewayVpcAttachments</a> to view your pending VPC attachment requests. Use
     * <a>AcceptTransitGatewayVpcAttachment</a> to accept a VPC attachment request.
     * </p>
     * 
     * @param rejectTransitGatewayVpcAttachmentRequest
     * @return Result of the RejectTransitGatewayVpcAttachment operation returned by the service.
     * @sample AmazonEC2.RejectTransitGatewayVpcAttachment
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RejectTransitGatewayVpcAttachment"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public RejectTransitGatewayVpcAttachmentResult rejectTransitGatewayVpcAttachment(RejectTransitGatewayVpcAttachmentRequest request) {
        request = beforeClientExecution(request);
        return executeRejectTransitGatewayVpcAttachment(request);
    }

    @SdkInternalApi
    final RejectTransitGatewayVpcAttachmentResult executeRejectTransitGatewayVpcAttachment(
            RejectTransitGatewayVpcAttachmentRequest rejectTransitGatewayVpcAttachmentRequest) {

        ExecutionContext executionContext = createExecutionContext(rejectTransitGatewayVpcAttachmentRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RejectTransitGatewayVpcAttachmentRequest> request = null;
        Response<RejectTransitGatewayVpcAttachmentResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RejectTransitGatewayVpcAttachmentRequestMarshaller().marshall(super.beforeMarshalling(rejectTransitGatewayVpcAttachmentRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RejectTransitGatewayVpcAttachment");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RejectTransitGatewayVpcAttachmentResult> responseHandler = new StaxResponseHandler<RejectTransitGatewayVpcAttachmentResult>(
                    new RejectTransitGatewayVpcAttachmentResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Rejects one or more VPC endpoint connection requests to your VPC endpoint service.
     * </p>
     * 
     * @param rejectVpcEndpointConnectionsRequest
     * @return Result of the RejectVpcEndpointConnections operation returned by the service.
     * @sample AmazonEC2.RejectVpcEndpointConnections
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RejectVpcEndpointConnections"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public RejectVpcEndpointConnectionsResult rejectVpcEndpointConnections(RejectVpcEndpointConnectionsRequest request) {
        request = beforeClientExecution(request);
        return executeRejectVpcEndpointConnections(request);
    }

    @SdkInternalApi
    final RejectVpcEndpointConnectionsResult executeRejectVpcEndpointConnections(RejectVpcEndpointConnectionsRequest rejectVpcEndpointConnectionsRequest) {

        ExecutionContext executionContext = createExecutionContext(rejectVpcEndpointConnectionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RejectVpcEndpointConnectionsRequest> request = null;
        Response<RejectVpcEndpointConnectionsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RejectVpcEndpointConnectionsRequestMarshaller().marshall(super.beforeMarshalling(rejectVpcEndpointConnectionsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RejectVpcEndpointConnections");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RejectVpcEndpointConnectionsResult> responseHandler = new StaxResponseHandler<RejectVpcEndpointConnectionsResult>(
                    new RejectVpcEndpointConnectionsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Rejects a VPC peering connection request. The VPC peering connection must be in the
     * <code>pending-acceptance</code> state. Use the <a>DescribeVpcPeeringConnections</a> request to view your
     * outstanding VPC peering connection requests. To delete an active VPC peering connection, or to delete a VPC
     * peering connection request that you initiated, use <a>DeleteVpcPeeringConnection</a>.
     * </p>
     * 
     * @param rejectVpcPeeringConnectionRequest
     * @return Result of the RejectVpcPeeringConnection operation returned by the service.
     * @sample AmazonEC2.RejectVpcPeeringConnection
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RejectVpcPeeringConnection" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public RejectVpcPeeringConnectionResult rejectVpcPeeringConnection(RejectVpcPeeringConnectionRequest request) {
        request = beforeClientExecution(request);
        return executeRejectVpcPeeringConnection(request);
    }

    @SdkInternalApi
    final RejectVpcPeeringConnectionResult executeRejectVpcPeeringConnection(RejectVpcPeeringConnectionRequest rejectVpcPeeringConnectionRequest) {

        ExecutionContext executionContext = createExecutionContext(rejectVpcPeeringConnectionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RejectVpcPeeringConnectionRequest> request = null;
        Response<RejectVpcPeeringConnectionResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RejectVpcPeeringConnectionRequestMarshaller().marshall(super.beforeMarshalling(rejectVpcPeeringConnectionRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RejectVpcPeeringConnection");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RejectVpcPeeringConnectionResult> responseHandler = new StaxResponseHandler<RejectVpcPeeringConnectionResult>(
                    new RejectVpcPeeringConnectionResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Releases the specified Elastic IP address.
     * </p>
     * <p>
     * [EC2-Classic, default VPC] Releasing an Elastic IP address automatically disassociates it from any instance that
     * it's associated with. To disassociate an Elastic IP address without releasing it, use <a>DisassociateAddress</a>.
     * </p>
     * <p>
     * [Nondefault VPC] You must use <a>DisassociateAddress</a> to disassociate the Elastic IP address before you can
     * release it. Otherwise, Amazon EC2 returns an error (<code>InvalidIPAddress.InUse</code>).
     * </p>
     * <p>
     * After releasing an Elastic IP address, it is released to the IP address pool. Be sure to update your DNS records
     * and any servers or devices that communicate with the address. If you attempt to release an Elastic IP address
     * that you already released, you'll get an <code>AuthFailure</code> error if the address is already allocated to
     * another AWS account.
     * </p>
     * <p>
     * [EC2-VPC] After you release an Elastic IP address for use in a VPC, you might be able to recover it. For more
     * information, see <a>AllocateAddress</a>.
     * </p>
     * 
     * @param releaseAddressRequest
     * @return Result of the ReleaseAddress operation returned by the service.
     * @sample AmazonEC2.ReleaseAddress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReleaseAddress" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ReleaseAddressResult releaseAddress(ReleaseAddressRequest request) {
        request = beforeClientExecution(request);
        return executeReleaseAddress(request);
    }

    @SdkInternalApi
    final ReleaseAddressResult executeReleaseAddress(ReleaseAddressRequest releaseAddressRequest) {

        ExecutionContext executionContext = createExecutionContext(releaseAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReleaseAddressRequest> request = null;
        Response<ReleaseAddressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReleaseAddressRequestMarshaller().marshall(super.beforeMarshalling(releaseAddressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReleaseAddress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReleaseAddressResult> responseHandler = new StaxResponseHandler<ReleaseAddressResult>(
                    new ReleaseAddressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * When you no longer want to use an On-Demand Dedicated Host it can be released. On-Demand billing is stopped and
     * the host goes into <code>released</code> state. The host ID of Dedicated Hosts that have been released can no
     * longer be specified in another request, for example, to modify the host. You must stop or terminate all instances
     * on a host before it can be released.
     * </p>
     * <p>
     * When Dedicated Hosts are released, it may take some time for them to stop counting toward your limit and you may
     * receive capacity errors when trying to allocate new Dedicated Hosts. Wait a few minutes and then try again.
     * </p>
     * <p>
     * Released hosts still appear in a <a>DescribeHosts</a> response.
     * </p>
     * 
     * @param releaseHostsRequest
     * @return Result of the ReleaseHosts operation returned by the service.
     * @sample AmazonEC2.ReleaseHosts
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReleaseHosts" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ReleaseHostsResult releaseHosts(ReleaseHostsRequest request) {
        request = beforeClientExecution(request);
        return executeReleaseHosts(request);
    }

    @SdkInternalApi
    final ReleaseHostsResult executeReleaseHosts(ReleaseHostsRequest releaseHostsRequest) {

        ExecutionContext executionContext = createExecutionContext(releaseHostsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReleaseHostsRequest> request = null;
        Response<ReleaseHostsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReleaseHostsRequestMarshaller().marshall(super.beforeMarshalling(releaseHostsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReleaseHosts");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReleaseHostsResult> responseHandler = new StaxResponseHandler<ReleaseHostsResult>(new ReleaseHostsResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Replaces an IAM instance profile for the specified running instance. You can use this action to change the IAM
     * instance profile that's associated with an instance without having to disassociate the existing IAM instance
     * profile first.
     * </p>
     * <p>
     * Use <a>DescribeIamInstanceProfileAssociations</a> to get the association ID.
     * </p>
     * 
     * @param replaceIamInstanceProfileAssociationRequest
     * @return Result of the ReplaceIamInstanceProfileAssociation operation returned by the service.
     * @sample AmazonEC2.ReplaceIamInstanceProfileAssociation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceIamInstanceProfileAssociation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ReplaceIamInstanceProfileAssociationResult replaceIamInstanceProfileAssociation(ReplaceIamInstanceProfileAssociationRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceIamInstanceProfileAssociation(request);
    }

    @SdkInternalApi
    final ReplaceIamInstanceProfileAssociationResult executeReplaceIamInstanceProfileAssociation(
            ReplaceIamInstanceProfileAssociationRequest replaceIamInstanceProfileAssociationRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceIamInstanceProfileAssociationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceIamInstanceProfileAssociationRequest> request = null;
        Response<ReplaceIamInstanceProfileAssociationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceIamInstanceProfileAssociationRequestMarshaller().marshall(super
                        .beforeMarshalling(replaceIamInstanceProfileAssociationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceIamInstanceProfileAssociation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceIamInstanceProfileAssociationResult> responseHandler = new StaxResponseHandler<ReplaceIamInstanceProfileAssociationResult>(
                    new ReplaceIamInstanceProfileAssociationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Changes which network ACL a subnet is associated with. By default when you create a subnet, it's automatically
     * associated with the default network ACL. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html">Network ACLs</a> in the <i>Amazon
     * Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * This is an idempotent operation.
     * </p>
     * 
     * @param replaceNetworkAclAssociationRequest
     * @return Result of the ReplaceNetworkAclAssociation operation returned by the service.
     * @sample AmazonEC2.ReplaceNetworkAclAssociation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceNetworkAclAssociation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ReplaceNetworkAclAssociationResult replaceNetworkAclAssociation(ReplaceNetworkAclAssociationRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceNetworkAclAssociation(request);
    }

    @SdkInternalApi
    final ReplaceNetworkAclAssociationResult executeReplaceNetworkAclAssociation(ReplaceNetworkAclAssociationRequest replaceNetworkAclAssociationRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceNetworkAclAssociationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceNetworkAclAssociationRequest> request = null;
        Response<ReplaceNetworkAclAssociationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceNetworkAclAssociationRequestMarshaller().marshall(super.beforeMarshalling(replaceNetworkAclAssociationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceNetworkAclAssociation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceNetworkAclAssociationResult> responseHandler = new StaxResponseHandler<ReplaceNetworkAclAssociationResult>(
                    new ReplaceNetworkAclAssociationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Replaces an entry (rule) in a network ACL. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html">Network ACLs</a> in the <i>Amazon
     * Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param replaceNetworkAclEntryRequest
     * @return Result of the ReplaceNetworkAclEntry operation returned by the service.
     * @sample AmazonEC2.ReplaceNetworkAclEntry
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceNetworkAclEntry" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ReplaceNetworkAclEntryResult replaceNetworkAclEntry(ReplaceNetworkAclEntryRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceNetworkAclEntry(request);
    }

    @SdkInternalApi
    final ReplaceNetworkAclEntryResult executeReplaceNetworkAclEntry(ReplaceNetworkAclEntryRequest replaceNetworkAclEntryRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceNetworkAclEntryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceNetworkAclEntryRequest> request = null;
        Response<ReplaceNetworkAclEntryResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceNetworkAclEntryRequestMarshaller().marshall(super.beforeMarshalling(replaceNetworkAclEntryRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceNetworkAclEntry");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceNetworkAclEntryResult> responseHandler = new StaxResponseHandler<ReplaceNetworkAclEntryResult>(
                    new ReplaceNetworkAclEntryResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Replaces an existing route within a route table in a VPC. You must provide only one of the following: internet
     * gateway or virtual private gateway, NAT instance, NAT gateway, VPC peering connection, network interface, or
     * egress-only internet gateway.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param replaceRouteRequest
     * @return Result of the ReplaceRoute operation returned by the service.
     * @sample AmazonEC2.ReplaceRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceRoute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ReplaceRouteResult replaceRoute(ReplaceRouteRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceRoute(request);
    }

    @SdkInternalApi
    final ReplaceRouteResult executeReplaceRoute(ReplaceRouteRequest replaceRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceRouteRequest> request = null;
        Response<ReplaceRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceRouteRequestMarshaller().marshall(super.beforeMarshalling(replaceRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceRouteResult> responseHandler = new StaxResponseHandler<ReplaceRouteResult>(new ReplaceRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Changes the route table associated with a given subnet in a VPC. After the operation completes, the subnet uses
     * the routes in the new route table it's associated with. For more information about route tables, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html">Route Tables</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * <p>
     * You can also use ReplaceRouteTableAssociation to change which table is the main route table in the VPC. You just
     * specify the main route table's association ID and the route table to be the new main route table.
     * </p>
     * 
     * @param replaceRouteTableAssociationRequest
     * @return Result of the ReplaceRouteTableAssociation operation returned by the service.
     * @sample AmazonEC2.ReplaceRouteTableAssociation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceRouteTableAssociation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ReplaceRouteTableAssociationResult replaceRouteTableAssociation(ReplaceRouteTableAssociationRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceRouteTableAssociation(request);
    }

    @SdkInternalApi
    final ReplaceRouteTableAssociationResult executeReplaceRouteTableAssociation(ReplaceRouteTableAssociationRequest replaceRouteTableAssociationRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceRouteTableAssociationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceRouteTableAssociationRequest> request = null;
        Response<ReplaceRouteTableAssociationResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceRouteTableAssociationRequestMarshaller().marshall(super.beforeMarshalling(replaceRouteTableAssociationRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceRouteTableAssociation");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceRouteTableAssociationResult> responseHandler = new StaxResponseHandler<ReplaceRouteTableAssociationResult>(
                    new ReplaceRouteTableAssociationResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Replaces the specified route in the specified transit gateway route table.
     * </p>
     * 
     * @param replaceTransitGatewayRouteRequest
     * @return Result of the ReplaceTransitGatewayRoute operation returned by the service.
     * @sample AmazonEC2.ReplaceTransitGatewayRoute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReplaceTransitGatewayRoute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ReplaceTransitGatewayRouteResult replaceTransitGatewayRoute(ReplaceTransitGatewayRouteRequest request) {
        request = beforeClientExecution(request);
        return executeReplaceTransitGatewayRoute(request);
    }

    @SdkInternalApi
    final ReplaceTransitGatewayRouteResult executeReplaceTransitGatewayRoute(ReplaceTransitGatewayRouteRequest replaceTransitGatewayRouteRequest) {

        ExecutionContext executionContext = createExecutionContext(replaceTransitGatewayRouteRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReplaceTransitGatewayRouteRequest> request = null;
        Response<ReplaceTransitGatewayRouteResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReplaceTransitGatewayRouteRequestMarshaller().marshall(super.beforeMarshalling(replaceTransitGatewayRouteRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReplaceTransitGatewayRoute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReplaceTransitGatewayRouteResult> responseHandler = new StaxResponseHandler<ReplaceTransitGatewayRouteResult>(
                    new ReplaceTransitGatewayRouteResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Submits feedback about the status of an instance. The instance must be in the <code>running</code> state. If your
     * experience with the instance differs from the instance status returned by <a>DescribeInstanceStatus</a>, use
     * <a>ReportInstanceStatus</a> to report your experience with the instance. Amazon EC2 collects this information to
     * improve the accuracy of status checks.
     * </p>
     * <p>
     * Use of this action does not change the value returned by <a>DescribeInstanceStatus</a>.
     * </p>
     * 
     * @param reportInstanceStatusRequest
     *        Contains the parameters for ReportInstanceStatus.
     * @return Result of the ReportInstanceStatus operation returned by the service.
     * @sample AmazonEC2.ReportInstanceStatus
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ReportInstanceStatus" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ReportInstanceStatusResult reportInstanceStatus(ReportInstanceStatusRequest request) {
        request = beforeClientExecution(request);
        return executeReportInstanceStatus(request);
    }

    @SdkInternalApi
    final ReportInstanceStatusResult executeReportInstanceStatus(ReportInstanceStatusRequest reportInstanceStatusRequest) {

        ExecutionContext executionContext = createExecutionContext(reportInstanceStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ReportInstanceStatusRequest> request = null;
        Response<ReportInstanceStatusResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ReportInstanceStatusRequestMarshaller().marshall(super.beforeMarshalling(reportInstanceStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReportInstanceStatus");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ReportInstanceStatusResult> responseHandler = new StaxResponseHandler<ReportInstanceStatusResult>(
                    new ReportInstanceStatusResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a Spot Fleet request.
     * </p>
     * <p>
     * The Spot Fleet request specifies the total target capacity and the On-Demand target capacity. Amazon EC2
     * calculates the difference between the total capacity and On-Demand capacity, and launches the difference as Spot
     * capacity.
     * </p>
     * <p>
     * You can submit a single request that includes multiple launch specifications that vary by instance type, AMI,
     * Availability Zone, or subnet.
     * </p>
     * <p>
     * By default, the Spot Fleet requests Spot Instances in the Spot pool where the price per unit is the lowest. Each
     * launch specification can include its own instance weighting that reflects the value of the instance type to your
     * application workload.
     * </p>
     * <p>
     * Alternatively, you can specify that the Spot Fleet distribute the target capacity across the Spot pools included
     * in its launch specifications. By ensuring that the Spot Instances in your Spot Fleet are in different Spot pools,
     * you can improve the availability of your fleet.
     * </p>
     * <p>
     * You can specify tags for the Spot Instances. You cannot tag other resource types in a Spot Fleet request because
     * only the <code>instance</code> resource type is supported.
     * </p>
     * <p>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-requests.html">Spot Fleet Requests</a> in the
     * <i>Amazon EC2 User Guide for Linux Instances</i>.
     * </p>
     * 
     * @param requestSpotFleetRequest
     *        Contains the parameters for RequestSpotFleet.
     * @return Result of the RequestSpotFleet operation returned by the service.
     * @sample AmazonEC2.RequestSpotFleet
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RequestSpotFleet" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RequestSpotFleetResult requestSpotFleet(RequestSpotFleetRequest request) {
        request = beforeClientExecution(request);
        return executeRequestSpotFleet(request);
    }

    @SdkInternalApi
    final RequestSpotFleetResult executeRequestSpotFleet(RequestSpotFleetRequest requestSpotFleetRequest) {

        ExecutionContext executionContext = createExecutionContext(requestSpotFleetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RequestSpotFleetRequest> request = null;
        Response<RequestSpotFleetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RequestSpotFleetRequestMarshaller().marshall(super.beforeMarshalling(requestSpotFleetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RequestSpotFleet");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RequestSpotFleetResult> responseHandler = new StaxResponseHandler<RequestSpotFleetResult>(
                    new RequestSpotFleetResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates a Spot Instance request.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-requests.html">Spot
     * Instance Requests</a> in the <i>Amazon EC2 User Guide for Linux Instances</i>.
     * </p>
     * 
     * @param requestSpotInstancesRequest
     *        Contains the parameters for RequestSpotInstances.
     * @return Result of the RequestSpotInstances operation returned by the service.
     * @sample AmazonEC2.RequestSpotInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RequestSpotInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RequestSpotInstancesResult requestSpotInstances(RequestSpotInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeRequestSpotInstances(request);
    }

    @SdkInternalApi
    final RequestSpotInstancesResult executeRequestSpotInstances(RequestSpotInstancesRequest requestSpotInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(requestSpotInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RequestSpotInstancesRequest> request = null;
        Response<RequestSpotInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RequestSpotInstancesRequestMarshaller().marshall(super.beforeMarshalling(requestSpotInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RequestSpotInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RequestSpotInstancesResult> responseHandler = new StaxResponseHandler<RequestSpotInstancesResult>(
                    new RequestSpotInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Resets the specified attribute of the specified Amazon FPGA Image (AFI) to its default value. You can only reset
     * the load permission attribute.
     * </p>
     * 
     * @param resetFpgaImageAttributeRequest
     * @return Result of the ResetFpgaImageAttribute operation returned by the service.
     * @sample AmazonEC2.ResetFpgaImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ResetFpgaImageAttribute" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public ResetFpgaImageAttributeResult resetFpgaImageAttribute(ResetFpgaImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeResetFpgaImageAttribute(request);
    }

    @SdkInternalApi
    final ResetFpgaImageAttributeResult executeResetFpgaImageAttribute(ResetFpgaImageAttributeRequest resetFpgaImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(resetFpgaImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetFpgaImageAttributeRequest> request = null;
        Response<ResetFpgaImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetFpgaImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(resetFpgaImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetFpgaImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ResetFpgaImageAttributeResult> responseHandler = new StaxResponseHandler<ResetFpgaImageAttributeResult>(
                    new ResetFpgaImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Resets an attribute of an AMI to its default value.
     * </p>
     * <note>
     * <p>
     * The productCodes attribute can't be reset.
     * </p>
     * </note>
     * 
     * @param resetImageAttributeRequest
     *        Contains the parameters for ResetImageAttribute.
     * @return Result of the ResetImageAttribute operation returned by the service.
     * @sample AmazonEC2.ResetImageAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ResetImageAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ResetImageAttributeResult resetImageAttribute(ResetImageAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeResetImageAttribute(request);
    }

    @SdkInternalApi
    final ResetImageAttributeResult executeResetImageAttribute(ResetImageAttributeRequest resetImageAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(resetImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetImageAttributeRequest> request = null;
        Response<ResetImageAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetImageAttributeRequestMarshaller().marshall(super.beforeMarshalling(resetImageAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetImageAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ResetImageAttributeResult> responseHandler = new StaxResponseHandler<ResetImageAttributeResult>(
                    new ResetImageAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Resets an attribute of an instance to its default value. To reset the <code>kernel</code> or <code>ramdisk</code>
     * , the instance must be in a stopped state. To reset the <code>sourceDestCheck</code>, the instance can be either
     * running or stopped.
     * </p>
     * <p>
     * The <code>sourceDestCheck</code> attribute controls whether source/destination checking is enabled. The default
     * value is <code>true</code>, which means checking is enabled. This value must be <code>false</code> for a NAT
     * instance to perform NAT. For more information, see <a
     * href="http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_NAT_Instance.html">NAT Instances</a> in the
     * <i>Amazon Virtual Private Cloud User Guide</i>.
     * </p>
     * 
     * @param resetInstanceAttributeRequest
     *        Contains the parameters for ResetInstanceAttribute.
     * @return Result of the ResetInstanceAttribute operation returned by the service.
     * @sample AmazonEC2.ResetInstanceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ResetInstanceAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ResetInstanceAttributeResult resetInstanceAttribute(ResetInstanceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeResetInstanceAttribute(request);
    }

    @SdkInternalApi
    final ResetInstanceAttributeResult executeResetInstanceAttribute(ResetInstanceAttributeRequest resetInstanceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(resetInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetInstanceAttributeRequest> request = null;
        Response<ResetInstanceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetInstanceAttributeRequestMarshaller().marshall(super.beforeMarshalling(resetInstanceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetInstanceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ResetInstanceAttributeResult> responseHandler = new StaxResponseHandler<ResetInstanceAttributeResult>(
                    new ResetInstanceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Resets a network interface attribute. You can specify only one attribute at a time.
     * </p>
     * 
     * @param resetNetworkInterfaceAttributeRequest
     *        Contains the parameters for ResetNetworkInterfaceAttribute.
     * @return Result of the ResetNetworkInterfaceAttribute operation returned by the service.
     * @sample AmazonEC2.ResetNetworkInterfaceAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ResetNetworkInterfaceAttribute"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public ResetNetworkInterfaceAttributeResult resetNetworkInterfaceAttribute(ResetNetworkInterfaceAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeResetNetworkInterfaceAttribute(request);
    }

    @SdkInternalApi
    final ResetNetworkInterfaceAttributeResult executeResetNetworkInterfaceAttribute(ResetNetworkInterfaceAttributeRequest resetNetworkInterfaceAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(resetNetworkInterfaceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetNetworkInterfaceAttributeRequest> request = null;
        Response<ResetNetworkInterfaceAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetNetworkInterfaceAttributeRequestMarshaller().marshall(super.beforeMarshalling(resetNetworkInterfaceAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetNetworkInterfaceAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ResetNetworkInterfaceAttributeResult> responseHandler = new StaxResponseHandler<ResetNetworkInterfaceAttributeResult>(
                    new ResetNetworkInterfaceAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Resets permission settings for the specified snapshot.
     * </p>
     * <p>
     * For more information about modifying snapshot permissions, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-modifying-snapshot-permissions.html">Sharing
     * Snapshots</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param resetSnapshotAttributeRequest
     *        Contains the parameters for ResetSnapshotAttribute.
     * @return Result of the ResetSnapshotAttribute operation returned by the service.
     * @sample AmazonEC2.ResetSnapshotAttribute
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/ResetSnapshotAttribute" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public ResetSnapshotAttributeResult resetSnapshotAttribute(ResetSnapshotAttributeRequest request) {
        request = beforeClientExecution(request);
        return executeResetSnapshotAttribute(request);
    }

    @SdkInternalApi
    final ResetSnapshotAttributeResult executeResetSnapshotAttribute(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) {

        ExecutionContext executionContext = createExecutionContext(resetSnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ResetSnapshotAttributeRequest> request = null;
        Response<ResetSnapshotAttributeResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ResetSnapshotAttributeRequestMarshaller().marshall(super.beforeMarshalling(resetSnapshotAttributeRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetSnapshotAttribute");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<ResetSnapshotAttributeResult> responseHandler = new StaxResponseHandler<ResetSnapshotAttributeResult>(
                    new ResetSnapshotAttributeResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Restores an Elastic IP address that was previously moved to the EC2-VPC platform back to the EC2-Classic
     * platform. You cannot move an Elastic IP address that was originally allocated for use in EC2-VPC. The Elastic IP
     * address must not be associated with an instance or network interface.
     * </p>
     * 
     * @param restoreAddressToClassicRequest
     * @return Result of the RestoreAddressToClassic operation returned by the service.
     * @sample AmazonEC2.RestoreAddressToClassic
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RestoreAddressToClassic" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public RestoreAddressToClassicResult restoreAddressToClassic(RestoreAddressToClassicRequest request) {
        request = beforeClientExecution(request);
        return executeRestoreAddressToClassic(request);
    }

    @SdkInternalApi
    final RestoreAddressToClassicResult executeRestoreAddressToClassic(RestoreAddressToClassicRequest restoreAddressToClassicRequest) {

        ExecutionContext executionContext = createExecutionContext(restoreAddressToClassicRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RestoreAddressToClassicRequest> request = null;
        Response<RestoreAddressToClassicResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RestoreAddressToClassicRequestMarshaller().marshall(super.beforeMarshalling(restoreAddressToClassicRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RestoreAddressToClassic");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RestoreAddressToClassicResult> responseHandler = new StaxResponseHandler<RestoreAddressToClassicResult>(
                    new RestoreAddressToClassicResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * [EC2-VPC only] Removes one or more egress rules from a security group for EC2-VPC. This action doesn't apply to
     * security groups for use in EC2-Classic. To remove a rule, the values that you specify (for example, ports) must
     * match the existing rule's values exactly.
     * </p>
     * <p>
     * Each rule consists of the protocol and the IPv4 or IPv6 CIDR range or source security group. For the TCP and UDP
     * protocols, you must also specify the destination port or range of ports. For the ICMP protocol, you must also
     * specify the ICMP type and code. If the security group rule has a description, you do not have to specify the
     * description to revoke the rule.
     * </p>
     * <p>
     * Rule changes are propagated to instances within the security group as quickly as possible. However, a small delay
     * might occur.
     * </p>
     * 
     * @param revokeSecurityGroupEgressRequest
     * @return Result of the RevokeSecurityGroupEgress operation returned by the service.
     * @sample AmazonEC2.RevokeSecurityGroupEgress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RevokeSecurityGroupEgress" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public RevokeSecurityGroupEgressResult revokeSecurityGroupEgress(RevokeSecurityGroupEgressRequest request) {
        request = beforeClientExecution(request);
        return executeRevokeSecurityGroupEgress(request);
    }

    @SdkInternalApi
    final RevokeSecurityGroupEgressResult executeRevokeSecurityGroupEgress(RevokeSecurityGroupEgressRequest revokeSecurityGroupEgressRequest) {

        ExecutionContext executionContext = createExecutionContext(revokeSecurityGroupEgressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RevokeSecurityGroupEgressRequest> request = null;
        Response<RevokeSecurityGroupEgressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RevokeSecurityGroupEgressRequestMarshaller().marshall(super.beforeMarshalling(revokeSecurityGroupEgressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RevokeSecurityGroupEgress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RevokeSecurityGroupEgressResult> responseHandler = new StaxResponseHandler<RevokeSecurityGroupEgressResult>(
                    new RevokeSecurityGroupEgressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Removes one or more ingress rules from a security group. To remove a rule, the values that you specify (for
     * example, ports) must match the existing rule's values exactly.
     * </p>
     * <note>
     * <p>
     * [EC2-Classic security groups only] If the values you specify do not match the existing rule's values, no error is
     * returned. Use <a>DescribeSecurityGroups</a> to verify that the rule has been removed.
     * </p>
     * </note>
     * <p>
     * Each rule consists of the protocol and the CIDR range or source security group. For the TCP and UDP protocols,
     * you must also specify the destination port or range of ports. For the ICMP protocol, you must also specify the
     * ICMP type and code. If the security group rule has a description, you do not have to specify the description to
     * revoke the rule.
     * </p>
     * <p>
     * Rule changes are propagated to instances within the security group as quickly as possible. However, a small delay
     * might occur.
     * </p>
     * 
     * @param revokeSecurityGroupIngressRequest
     * @return Result of the RevokeSecurityGroupIngress operation returned by the service.
     * @sample AmazonEC2.RevokeSecurityGroupIngress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RevokeSecurityGroupIngress" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public RevokeSecurityGroupIngressResult revokeSecurityGroupIngress(RevokeSecurityGroupIngressRequest request) {
        request = beforeClientExecution(request);
        return executeRevokeSecurityGroupIngress(request);
    }

    @SdkInternalApi
    final RevokeSecurityGroupIngressResult executeRevokeSecurityGroupIngress(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) {

        ExecutionContext executionContext = createExecutionContext(revokeSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RevokeSecurityGroupIngressRequest> request = null;
        Response<RevokeSecurityGroupIngressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RevokeSecurityGroupIngressRequestMarshaller().marshall(super.beforeMarshalling(revokeSecurityGroupIngressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RevokeSecurityGroupIngress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RevokeSecurityGroupIngressResult> responseHandler = new StaxResponseHandler<RevokeSecurityGroupIngressResult>(
                    new RevokeSecurityGroupIngressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    @Override
    @Deprecated
    public RevokeSecurityGroupIngressResult revokeSecurityGroupIngress() {
        return revokeSecurityGroupIngress(new RevokeSecurityGroupIngressRequest());
    }

    /**
     * <p>
     * Launches the specified number of instances using an AMI for which you have permissions.
     * </p>
     * <p>
     * You can specify a number of options, or leave the default options. The following rules apply:
     * </p>
     * <ul>
     * <li>
     * <p>
     * [EC2-VPC] If you don't specify a subnet ID, we choose a default subnet from your default VPC for you. If you
     * don't have a default VPC, you must specify a subnet ID in the request.
     * </p>
     * </li>
     * <li>
     * <p>
     * [EC2-Classic] If don't specify an Availability Zone, we choose one for you.
     * </p>
     * </li>
     * <li>
     * <p>
     * Some instance types must be launched into a VPC. If you do not have a default VPC, or if you do not specify a
     * subnet ID, the request fails. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-vpc.html#vpc-only-instance-types">Instance Types
     * Available Only in a VPC</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * [EC2-VPC] All instances have a network interface with a primary private IPv4 address. If you don't specify this
     * address, we choose one from the IPv4 range of your subnet.
     * </p>
     * </li>
     * <li>
     * <p>
     * Not all instance types support IPv6 addresses. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-types.html">Instance Types</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * If you don't specify a security group ID, we use the default security group. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html">Security Groups</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * If any of the AMIs have a product code attached for which the user has not subscribed, the request fails.
     * </p>
     * </li>
     * </ul>
     * <p>
     * You can create a <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-launch-templates.html">launch
     * template</a>, which is a resource that contains the parameters to launch an instance. When you launch an instance
     * using <a>RunInstances</a>, you can specify the launch template instead of specifying the launch parameters.
     * </p>
     * <p>
     * To ensure faster instance launches, break up large requests into smaller batches. For example, create five
     * separate launch requests for 100 instances each instead of one launch request for 500 instances.
     * </p>
     * <p>
     * An instance is ready for you to use when it's in the <code>running</code> state. You can check the state of your
     * instance using <a>DescribeInstances</a>. You can tag instances and EBS volumes during launch, after launch, or
     * both. For more information, see <a>CreateTags</a> and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html">Tagging Your Amazon EC2 Resources</a>.
     * </p>
     * <p>
     * Linux instances have access to the public key of the key pair at boot. You can use this key to provide secure
     * access to the instance. Amazon EC2 public images use this feature to provide secure access without passwords. For
     * more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html">Key
     * Pairs</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * For troubleshooting, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_InstanceStraightToTerminated.html">What To Do If
     * An Instance Immediately Terminates</a>, and <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/TroubleshootingInstancesConnecting.html">Troubleshooting
     * Connecting to Your Instance</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param runInstancesRequest
     *        Contains the parameters for RunInstances.
     * @return Result of the RunInstances operation returned by the service.
     * @sample AmazonEC2.RunInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RunInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RunInstancesResult runInstances(RunInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeRunInstances(request);
    }

    @SdkInternalApi
    final RunInstancesResult executeRunInstances(RunInstancesRequest runInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(runInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RunInstancesRequest> request = null;
        Response<RunInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RunInstancesRequestMarshaller().marshall(super.beforeMarshalling(runInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RunInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RunInstancesResult> responseHandler = new StaxResponseHandler<RunInstancesResult>(new RunInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Launches the specified Scheduled Instances.
     * </p>
     * <p>
     * Before you can launch a Scheduled Instance, you must purchase it and obtain an identifier using
     * <a>PurchaseScheduledInstances</a>.
     * </p>
     * <p>
     * You must launch a Scheduled Instance during its scheduled time period. You can't stop or reboot a Scheduled
     * Instance, but you can terminate it as needed. If you terminate a Scheduled Instance before the current scheduled
     * time period ends, you can launch it again after a few minutes. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-scheduled-instances.html">Scheduled Instances</a> in
     * the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param runScheduledInstancesRequest
     *        Contains the parameters for RunScheduledInstances.
     * @return Result of the RunScheduledInstances operation returned by the service.
     * @sample AmazonEC2.RunScheduledInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/RunScheduledInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public RunScheduledInstancesResult runScheduledInstances(RunScheduledInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeRunScheduledInstances(request);
    }

    @SdkInternalApi
    final RunScheduledInstancesResult executeRunScheduledInstances(RunScheduledInstancesRequest runScheduledInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(runScheduledInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RunScheduledInstancesRequest> request = null;
        Response<RunScheduledInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RunScheduledInstancesRequestMarshaller().marshall(super.beforeMarshalling(runScheduledInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RunScheduledInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<RunScheduledInstancesResult> responseHandler = new StaxResponseHandler<RunScheduledInstancesResult>(
                    new RunScheduledInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Searches for routes in the specified transit gateway route table.
     * </p>
     * 
     * @param searchTransitGatewayRoutesRequest
     * @return Result of the SearchTransitGatewayRoutes operation returned by the service.
     * @sample AmazonEC2.SearchTransitGatewayRoutes
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/SearchTransitGatewayRoutes" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public SearchTransitGatewayRoutesResult searchTransitGatewayRoutes(SearchTransitGatewayRoutesRequest request) {
        request = beforeClientExecution(request);
        return executeSearchTransitGatewayRoutes(request);
    }

    @SdkInternalApi
    final SearchTransitGatewayRoutesResult executeSearchTransitGatewayRoutes(SearchTransitGatewayRoutesRequest searchTransitGatewayRoutesRequest) {

        ExecutionContext executionContext = createExecutionContext(searchTransitGatewayRoutesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SearchTransitGatewayRoutesRequest> request = null;
        Response<SearchTransitGatewayRoutesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SearchTransitGatewayRoutesRequestMarshaller().marshall(super.beforeMarshalling(searchTransitGatewayRoutesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SearchTransitGatewayRoutes");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<SearchTransitGatewayRoutesResult> responseHandler = new StaxResponseHandler<SearchTransitGatewayRoutesResult>(
                    new SearchTransitGatewayRoutesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Starts an Amazon EBS-backed instance that you've previously stopped.
     * </p>
     * <p>
     * Instances that use Amazon EBS volumes as their root devices can be quickly stopped and started. When an instance
     * is stopped, the compute resources are released and you are not billed for instance usage. However, your root
     * partition Amazon EBS volume remains and continues to persist your data, and you are charged for Amazon EBS volume
     * usage. You can restart your instance at any time. Every time you start your Windows instance, Amazon EC2 charges
     * you for a full instance hour. If you stop and restart your Windows instance, a new instance hour begins and
     * Amazon EC2 charges you for another full instance hour even if you are still within the same 60-minute period when
     * it was stopped. Every time you start your Linux instance, Amazon EC2 charges a one-minute minimum for instance
     * usage, and thereafter charges per second for instance usage.
     * </p>
     * <p>
     * Before stopping an instance, make sure it is in a state from which it can be restarted. Stopping an instance does
     * not preserve data stored in RAM.
     * </p>
     * <p>
     * Performing this operation on an instance that uses an instance store as its root device returns an error.
     * </p>
     * <p>
     * For more information, see <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Stop_Start.html">Stopping
     * Instances</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param startInstancesRequest
     *        Contains the parameters for StartInstances.
     * @return Result of the StartInstances operation returned by the service.
     * @sample AmazonEC2.StartInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/StartInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public StartInstancesResult startInstances(StartInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeStartInstances(request);
    }

    @SdkInternalApi
    final StartInstancesResult executeStartInstances(StartInstancesRequest startInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(startInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartInstancesRequest> request = null;
        Response<StartInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartInstancesRequestMarshaller().marshall(super.beforeMarshalling(startInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "StartInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<StartInstancesResult> responseHandler = new StaxResponseHandler<StartInstancesResult>(
                    new StartInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Stops an Amazon EBS-backed instance.
     * </p>
     * <p>
     * We don't charge usage for a stopped instance, or data transfer fees; however, your root partition Amazon EBS
     * volume remains and continues to persist your data, and you are charged for Amazon EBS volume usage. Every time
     * you start your Windows instance, Amazon EC2 charges you for a full instance hour. If you stop and restart your
     * Windows instance, a new instance hour begins and Amazon EC2 charges you for another full instance hour even if
     * you are still within the same 60-minute period when it was stopped. Every time you start your Linux instance,
     * Amazon EC2 charges a one-minute minimum for instance usage, and thereafter charges per second for instance usage.
     * </p>
     * <p>
     * You can't start or stop Spot Instances, and you can't stop instance store-backed instances.
     * </p>
     * <p>
     * When you stop an instance, we shut it down. You can restart your instance at any time. Before stopping an
     * instance, make sure it is in a state from which it can be restarted. Stopping an instance does not preserve data
     * stored in RAM.
     * </p>
     * <p>
     * Stopping an instance is different to rebooting or terminating it. For example, when you stop an instance, the
     * root device and any other devices attached to the instance persist. When you terminate an instance, the root
     * device and any other devices attached during the instance launch are automatically deleted. For more information
     * about the differences between rebooting, stopping, and terminating instances, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html">Instance Lifecycle</a> in
     * the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * When you stop an instance, we attempt to shut it down forcibly after a short while. If your instance appears
     * stuck in the stopping state after a period of time, there may be an issue with the underlying host computer. For
     * more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/TroubleshootingInstancesStopping.html">Troubleshooting
     * Stopping Your Instance</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param stopInstancesRequest
     *        Contains the parameters for StopInstances.
     * @return Result of the StopInstances operation returned by the service.
     * @sample AmazonEC2.StopInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/StopInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public StopInstancesResult stopInstances(StopInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeStopInstances(request);
    }

    @SdkInternalApi
    final StopInstancesResult executeStopInstances(StopInstancesRequest stopInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(stopInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StopInstancesRequest> request = null;
        Response<StopInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StopInstancesRequestMarshaller().marshall(super.beforeMarshalling(stopInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "StopInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<StopInstancesResult> responseHandler = new StaxResponseHandler<StopInstancesResult>(new StopInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Shuts down one or more instances. This operation is idempotent; if you terminate an instance more than once, each
     * call succeeds.
     * </p>
     * <p>
     * If you specify multiple instances and the request fails (for example, because of a single incorrect instance ID),
     * none of the instances are terminated.
     * </p>
     * <p>
     * Terminated instances remain visible after termination (for approximately one hour).
     * </p>
     * <p>
     * By default, Amazon EC2 deletes all EBS volumes that were attached when the instance launched. Volumes attached
     * after instance launch continue running.
     * </p>
     * <p>
     * You can stop, start, and terminate EBS-backed instances. You can only terminate instance store-backed instances.
     * What happens to an instance differs if you stop it or terminate it. For example, when you stop an instance, the
     * root device and any other devices attached to the instance persist. When you terminate an instance, any attached
     * EBS volumes with the <code>DeleteOnTermination</code> block device mapping parameter set to <code>true</code> are
     * automatically deleted. For more information about the differences between stopping and terminating instances, see
     * <a href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html">Instance Lifecycle</a>
     * in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * <p>
     * For more information about troubleshooting, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/TroubleshootingInstancesShuttingDown.html"
     * >Troubleshooting Terminating Your Instance</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param terminateInstancesRequest
     *        Contains the parameters for TerminateInstances.
     * @return Result of the TerminateInstances operation returned by the service.
     * @sample AmazonEC2.TerminateInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/TerminateInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public TerminateInstancesResult terminateInstances(TerminateInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeTerminateInstances(request);
    }

    @SdkInternalApi
    final TerminateInstancesResult executeTerminateInstances(TerminateInstancesRequest terminateInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(terminateInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<TerminateInstancesRequest> request = null;
        Response<TerminateInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new TerminateInstancesRequestMarshaller().marshall(super.beforeMarshalling(terminateInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TerminateInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<TerminateInstancesResult> responseHandler = new StaxResponseHandler<TerminateInstancesResult>(
                    new TerminateInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Unassigns one or more IPv6 addresses from a network interface.
     * </p>
     * 
     * @param unassignIpv6AddressesRequest
     * @return Result of the UnassignIpv6Addresses operation returned by the service.
     * @sample AmazonEC2.UnassignIpv6Addresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/UnassignIpv6Addresses" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public UnassignIpv6AddressesResult unassignIpv6Addresses(UnassignIpv6AddressesRequest request) {
        request = beforeClientExecution(request);
        return executeUnassignIpv6Addresses(request);
    }

    @SdkInternalApi
    final UnassignIpv6AddressesResult executeUnassignIpv6Addresses(UnassignIpv6AddressesRequest unassignIpv6AddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(unassignIpv6AddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UnassignIpv6AddressesRequest> request = null;
        Response<UnassignIpv6AddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UnassignIpv6AddressesRequestMarshaller().marshall(super.beforeMarshalling(unassignIpv6AddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UnassignIpv6Addresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<UnassignIpv6AddressesResult> responseHandler = new StaxResponseHandler<UnassignIpv6AddressesResult>(
                    new UnassignIpv6AddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Unassigns one or more secondary private IP addresses from a network interface.
     * </p>
     * 
     * @param unassignPrivateIpAddressesRequest
     *        Contains the parameters for UnassignPrivateIpAddresses.
     * @return Result of the UnassignPrivateIpAddresses operation returned by the service.
     * @sample AmazonEC2.UnassignPrivateIpAddresses
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/UnassignPrivateIpAddresses" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public UnassignPrivateIpAddressesResult unassignPrivateIpAddresses(UnassignPrivateIpAddressesRequest request) {
        request = beforeClientExecution(request);
        return executeUnassignPrivateIpAddresses(request);
    }

    @SdkInternalApi
    final UnassignPrivateIpAddressesResult executeUnassignPrivateIpAddresses(UnassignPrivateIpAddressesRequest unassignPrivateIpAddressesRequest) {

        ExecutionContext executionContext = createExecutionContext(unassignPrivateIpAddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UnassignPrivateIpAddressesRequest> request = null;
        Response<UnassignPrivateIpAddressesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UnassignPrivateIpAddressesRequestMarshaller().marshall(super.beforeMarshalling(unassignPrivateIpAddressesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UnassignPrivateIpAddresses");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<UnassignPrivateIpAddressesResult> responseHandler = new StaxResponseHandler<UnassignPrivateIpAddressesResult>(
                    new UnassignPrivateIpAddressesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Disables detailed monitoring for a running instance. For more information, see <a
     * href="http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-cloudwatch.html">Monitoring Your Instances and
     * Volumes</a> in the <i>Amazon Elastic Compute Cloud User Guide</i>.
     * </p>
     * 
     * @param unmonitorInstancesRequest
     *        Contains the parameters for UnmonitorInstances.
     * @return Result of the UnmonitorInstances operation returned by the service.
     * @sample AmazonEC2.UnmonitorInstances
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/UnmonitorInstances" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public UnmonitorInstancesResult unmonitorInstances(UnmonitorInstancesRequest request) {
        request = beforeClientExecution(request);
        return executeUnmonitorInstances(request);
    }

    @SdkInternalApi
    final UnmonitorInstancesResult executeUnmonitorInstances(UnmonitorInstancesRequest unmonitorInstancesRequest) {

        ExecutionContext executionContext = createExecutionContext(unmonitorInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UnmonitorInstancesRequest> request = null;
        Response<UnmonitorInstancesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UnmonitorInstancesRequestMarshaller().marshall(super.beforeMarshalling(unmonitorInstancesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UnmonitorInstances");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<UnmonitorInstancesResult> responseHandler = new StaxResponseHandler<UnmonitorInstancesResult>(
                    new UnmonitorInstancesResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * [EC2-VPC only] Updates the description of an egress (outbound) security group rule. You can replace an existing
     * description, or add a description to a rule that did not have one previously.
     * </p>
     * <p>
     * You specify the description as part of the IP permissions structure. You can remove a description for a security
     * group rule by omitting the description parameter in the request.
     * </p>
     * 
     * @param updateSecurityGroupRuleDescriptionsEgressRequest
     * @return Result of the UpdateSecurityGroupRuleDescriptionsEgress operation returned by the service.
     * @sample AmazonEC2.UpdateSecurityGroupRuleDescriptionsEgress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/UpdateSecurityGroupRuleDescriptionsEgress"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateSecurityGroupRuleDescriptionsEgressResult updateSecurityGroupRuleDescriptionsEgress(UpdateSecurityGroupRuleDescriptionsEgressRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateSecurityGroupRuleDescriptionsEgress(request);
    }

    @SdkInternalApi
    final UpdateSecurityGroupRuleDescriptionsEgressResult executeUpdateSecurityGroupRuleDescriptionsEgress(
            UpdateSecurityGroupRuleDescriptionsEgressRequest updateSecurityGroupRuleDescriptionsEgressRequest) {

        ExecutionContext executionContext = createExecutionContext(updateSecurityGroupRuleDescriptionsEgressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateSecurityGroupRuleDescriptionsEgressRequest> request = null;
        Response<UpdateSecurityGroupRuleDescriptionsEgressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateSecurityGroupRuleDescriptionsEgressRequestMarshaller().marshall(super
                        .beforeMarshalling(updateSecurityGroupRuleDescriptionsEgressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateSecurityGroupRuleDescriptionsEgress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<UpdateSecurityGroupRuleDescriptionsEgressResult> responseHandler = new StaxResponseHandler<UpdateSecurityGroupRuleDescriptionsEgressResult>(
                    new UpdateSecurityGroupRuleDescriptionsEgressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Updates the description of an ingress (inbound) security group rule. You can replace an existing description, or
     * add a description to a rule that did not have one previously.
     * </p>
     * <p>
     * You specify the description as part of the IP permissions structure. You can remove a description for a security
     * group rule by omitting the description parameter in the request.
     * </p>
     * 
     * @param updateSecurityGroupRuleDescriptionsIngressRequest
     * @return Result of the UpdateSecurityGroupRuleDescriptionsIngress operation returned by the service.
     * @sample AmazonEC2.UpdateSecurityGroupRuleDescriptionsIngress
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/UpdateSecurityGroupRuleDescriptionsIngress"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public UpdateSecurityGroupRuleDescriptionsIngressResult updateSecurityGroupRuleDescriptionsIngress(UpdateSecurityGroupRuleDescriptionsIngressRequest request) {
        request = beforeClientExecution(request);
        return executeUpdateSecurityGroupRuleDescriptionsIngress(request);
    }

    @SdkInternalApi
    final UpdateSecurityGroupRuleDescriptionsIngressResult executeUpdateSecurityGroupRuleDescriptionsIngress(
            UpdateSecurityGroupRuleDescriptionsIngressRequest updateSecurityGroupRuleDescriptionsIngressRequest) {

        ExecutionContext executionContext = createExecutionContext(updateSecurityGroupRuleDescriptionsIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateSecurityGroupRuleDescriptionsIngressRequest> request = null;
        Response<UpdateSecurityGroupRuleDescriptionsIngressResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateSecurityGroupRuleDescriptionsIngressRequestMarshaller().marshall(super
                        .beforeMarshalling(updateSecurityGroupRuleDescriptionsIngressRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateSecurityGroupRuleDescriptionsIngress");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<UpdateSecurityGroupRuleDescriptionsIngressResult> responseHandler = new StaxResponseHandler<UpdateSecurityGroupRuleDescriptionsIngressResult>(
                    new UpdateSecurityGroupRuleDescriptionsIngressResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Stops advertising an IPv4 address range that is provisioned as an address pool.
     * </p>
     * <p>
     * You can perform this operation at most once every 10 seconds, even if you specify different address ranges each
     * time.
     * </p>
     * <p>
     * It can take a few minutes before traffic to the specified addresses stops routing to AWS because of BGP
     * propagation delays.
     * </p>
     * 
     * @param withdrawByoipCidrRequest
     * @return Result of the WithdrawByoipCidr operation returned by the service.
     * @sample AmazonEC2.WithdrawByoipCidr
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/WithdrawByoipCidr" target="_top">AWS API
     *      Documentation</a>
     */
    @Override
    public WithdrawByoipCidrResult withdrawByoipCidr(WithdrawByoipCidrRequest request) {
        request = beforeClientExecution(request);
        return executeWithdrawByoipCidr(request);
    }

    @SdkInternalApi
    final WithdrawByoipCidrResult executeWithdrawByoipCidr(WithdrawByoipCidrRequest withdrawByoipCidrRequest) {

        ExecutionContext executionContext = createExecutionContext(withdrawByoipCidrRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<WithdrawByoipCidrRequest> request = null;
        Response<WithdrawByoipCidrResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new WithdrawByoipCidrRequestMarshaller().marshall(super.beforeMarshalling(withdrawByoipCidrRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
                request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
                request.addHandlerContext(HandlerContextKey.SERVICE_ID, "EC2");
                request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "WithdrawByoipCidr");
                request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            StaxResponseHandler<WithdrawByoipCidrResult> responseHandler = new StaxResponseHandler<WithdrawByoipCidrResult>(
                    new WithdrawByoipCidrResultStaxUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Checks whether you have the required permissions for the provided Amazon EC2 operation, without actually running
     * it. The returned DryRunResult object contains the information of whether the dry-run was successful. This method
     * will throw exception when the service response does not clearly indicate whether you have the permission.
     *
     * @param request
     *        The request object for any Amazon EC2 operation supported with dry-run.
     *
     * @return A DryRunResult object that contains the information of whether the dry-run was successful.
     *
     * @throws AmazonClientException
     *         If any internal errors are encountered inside the client while attempting to make the request or handle
     *         the response. Or if the service response does not clearly indicate whether you have the permission.
     * @throws AmazonServiceException
     *         If an error response is returned by Amazon EC2 indicating either a problem with the data in the request,
     *         or a server side issue.
     */
    public <X extends AmazonWebServiceRequest> DryRunResult<X> dryRun(DryRunSupportedRequest<X> request) throws AmazonServiceException, AmazonClientException {
        Request<X> dryRunRequest = request.getDryRunRequest();
        ExecutionContext executionContext = createExecutionContext(dryRunRequest);
        try {
            invoke(dryRunRequest, new StaxResponseHandler<Void>(new VoidStaxUnmarshaller<Void>()), executionContext);
            throw new AmazonClientException("Unrecognized service response for the dry-run request.");
        } catch (AmazonServiceException ase) {
            if (ase.getErrorCode().equals("DryRunOperation") && ase.getStatusCode() == 412) {
                return new DryRunResult<X>(true, request, ase.getMessage(), ase);
            } else if (ase.getErrorCode().equals("UnauthorizedOperation") && ase.getStatusCode() == 403) {
                return new DryRunResult<X>(false, request, ase.getMessage(), ase);
            } else if (ase.getErrorCode().equals("AuthFailure")) {
                return new DryRunResult<X>(false, request, ase.getMessage(), ase);
            }
            throw new AmazonClientException("Unrecognized service response for the dry-run request.", ase);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for debugging issues
     * where a service isn't acting as expected. This data isn't considered part of the result data returned by an
     * operation, so it's available through this separate, diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access this extra diagnostic
     * information for an executed request, you should use this method to retrieve it as soon as possible after
     * executing the request.
     *
     * @param request
     *        The originally executed request
     *
     * @return The response metadata for the specified request, or null if none is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        return invoke(request, responseHandler, executionContext, null, null);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, URI cachedEndpoint, URI uriFromEndpointTrait) {

        executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));

        return doInvoke(request, responseHandler, executionContext, cachedEndpoint, uriFromEndpointTrait);
    }

    /**
     * Invoke with no authentication. Credentials are not required and any credentials set on the client or request will
     * be ignored for this operation.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext) {

        return doInvoke(request, responseHandler, executionContext, null, null);
    }

    /**
     * Invoke the request using the http client. Assumes credentials (or lack thereof) have been configured in the
     * ExecutionContext beforehand.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, URI discoveredEndpoint, URI uriFromEndpointTrait) {

        if (discoveredEndpoint != null) {
            request.setEndpoint(discoveredEndpoint);
            request.getOriginalRequest().getRequestClientOptions().appendUserAgent("endpoint-discovery");
        } else if (uriFromEndpointTrait != null) {
            request.setEndpoint(uriFromEndpointTrait);
        } else {
            request.setEndpoint(endpoint);
        }

        request.setTimeOffset(timeOffset);

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }

    @Override
    public AmazonEC2Waiters waiters() {
        if (waiters == null) {
            synchronized (this) {
                if (waiters == null) {
                    waiters = new AmazonEC2Waiters(this);
                }
            }
        }
        return waiters;
    }

    @Override
    public void shutdown() {
        super.shutdown();
        if (waiters != null) {
            waiters.shutdown();
        }
    }

}
