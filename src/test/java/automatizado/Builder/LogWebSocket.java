import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

@ServerEndpoint("/logs")
public class LogWebSocket {
    private static final Logger logger = Logger
            .getLogger(LogWebSocket.class
                    .getName());
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions
                .add(session);
        logger
                .info("Conexão WebSocket aberta: " + session
                        .getId());
    }

    @OnClose
    public void onClose(Session session) {
        sessions
                .remove(session);
        logger
                .info("Conexão WebSocket fechada: " + session
                        .getId());
    }

    public static void sendLog(String logMessage) {
        for (Session session : sessions) {
            if (session
                    .isOpen()) {
                try {
                    session
                            .getBasicRemote()
                            .sendText(logMessage);
                } catch (IOException e) {
                    logger
                            .warning("Erro ao enviar log para a sessão " + session
                                    .getId() + ": "
                                    + e
                                            .getMessage());
                }
            }
        }
    }
}
