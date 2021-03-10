package com.kafka.stream.consumer.Service;

import org.apache.kafka.streams.processor.AbstractProcessor;
import org.apache.kafka.streams.processor.ProcessorContext;

public class KafkaStreamConsumerServices extends AbstractProcessor<String, String> {

    private String serviceNameConfig;

    private ProcessorContext processorContext;


    public KafkaStreamConsumerServices(String serviceNameConfig) {
        this.serviceNameConfig = serviceNameConfig;
    }

    @Override
    public void process(String key, String payload) {
        try{
            long offset = this.processorContext.offset();
            System.out.println("Processing message" + payload);
        } catch (Exception e) {
            System.out.println("Processing error" + e.getMessage());
            System.out.println(e);
        }

    }

    @Override
    public void init(ProcessorContext context) {
        this.processorContext = context;
    }

    @Override
    public void close() {
        // nothing to do
    }


}
