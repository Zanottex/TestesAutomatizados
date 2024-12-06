import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint("/logs")
public class LogWebSocket {
    private static final Logger logger = Logger
            .getLogger(LogWebSocket.class
                    .getName());
    private static Session session;

    @OnOpen
    public void onOpen(Session session) {
        LogWebSocket.session = session;
        logger
                .info("Conexão WebSocket aberta.");
    }

    @OnClose
    public void onClose() {
        session = null;
        logger
                .info("Conexão WebSocket fechada.");
    }

    public static void sendLog(String logMessage) {
        if (session != null && session
                .isOpen()) {
            try {
                session
                        .getBasicRemote()
                        .sendText(logMessage);
            } catch (IOException e) {
                logger
                        .warning("Erro ao enviar log: " + e
                                .getMessage());
            }
        }
    }
}
