package demo.exams.twentytwo.tesco;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ClientGetterTest {

    private ClientGetter clientGetter = new ClientGetter();

    @Test
    public void testHappyPath() {
        ClientTransaction clientTx1 = new ClientTransaction();
        clientTx1.setClientId(1L);
        clientTx1.setAmount(100L);

        ClientTransaction clientTx2 = new ClientTransaction();
        clientTx2.setClientId(1L);
        clientTx2.setAmount(90L);

        ClientTransaction clientTx3 = new ClientTransaction();
        clientTx3.setClientId(2L);
        clientTx3.setAmount(150L);

        ClientTransaction clientTx4 = new ClientTransaction();
        clientTx4.setClientId(3L);
        clientTx4.setAmount(180L);

        ClientTransaction clientTx5 = new ClientTransaction();
        clientTx5.setClientId(4L);
        clientTx5.setAmount(10L);

        ClientTransaction clientTx6 = new ClientTransaction();
        clientTx6.setClientId(4L);
        clientTx6.setAmount(100L);

        ClientTransaction clientTx7 = new ClientTransaction();
        clientTx7.setClientId(5L);
        clientTx7.setAmount(200L);

        List<ClientTransaction> clientTxList = Arrays.asList(clientTx1, clientTx2, clientTx3, clientTx4, clientTx5, clientTx6, clientTx7);

        int k = 3;

        List<String> expected = Arrays.asList("5", "1", "3");

        List<String> actual = clientGetter.getTopKClients(clientTxList, k);

        Assert.assertEquals(expected, actual);


    }
}
