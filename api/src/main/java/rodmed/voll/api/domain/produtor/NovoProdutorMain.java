package rodmed.voll.api.domain.produtor;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import tools.jackson.databind.ser.jdk.StringSerializer;

import java.util.Properties;

public class NovoProdutorMain {

    public static void main(String[] args) {
        var producer = new KafkaProducer<String, String>(properties());
        var value = "123456987554";
        var record = new ProducerRecord<String, String>("ECOMMERCE_NOVO_PEDIDO", "chave", value);
        producer.send(record);
    }

    private static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
                return properties;
    }
}
