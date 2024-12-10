document.getElementById("start-test").addEventListener("click", function() {
    const tipoSelecionado = document.getElementById("step-select").value; // ou obtenha outras configurações do formulário
    const payload = {
        tipo: parseInt(tipoSelecionado)
    };

    fetch('http://localhost:8080/api/teste/iniciar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Teste iniciado:', data);
        alert('Teste iniciado com sucesso!');
    })
    .catch(error => {
        console.error('Erro ao iniciar o teste:', error);
        alert('Erro ao iniciar o teste');
    });
});

// Função para adicionar um log no painel
function addLog(message) {
    const logPanel = document.getElementById('log-panel');
    const logMessage = document.createElement('div');
    logMessage.textContent = message;
    logPanel.appendChild(logMessage);

    // Faz a rolagem automaticamente para a última mensagem
    logPanel.scrollTop = logPanel.scrollHeight;
}

// Exemplo de uso - Adicionando logs
addLog("Log de inicialização do sistema...");
addLog("Conexão com o servidor estabelecida.");
addLog("Erro: Falha na conexão com a base de dados.");

// Função para baixar os logs
document.getElementById('download-log').addEventListener('click', () => {
    const logPanel = document.getElementById('log-panel');
    const logs = logPanel.innerText;

    const blob = new Blob([logs], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'logs.txt';
    link.click();
});
