const apiUrl = "http://localhost:8080/api/gestao";


// Carregar lista ao iniciar
document.addEventListener("DOMContentLoaded", carregarGestores);

// Submiss�o do formulario
document.getElementById("gestaoForm").addEventListener("submit", (e) => {
    e.preventDefault();

    const id = document.getElementById("id").value;
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const senha = document.getElementById("senha").value;
    const gestorAdministrativo = document.getElementById("gestorAdministrativo").checked;

    const dados = { nome, cpf, senha, gestorAdministrativo };

    if (id) {
        // Atualizar
        fetch(`${apiUrl}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados),
        }).then(carregarGestores);
    } else {
        // Criar
        fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(dados),
        }).then(carregarGestores);
    }

    e.target.reset();
});

// Carregar gestores
function carregarGestores() {
    fetch(apiUrl)
        .then((res) => res.json())
        .then((data) => {
            const table = document.getElementById("gestoresTable");
            table.innerHTML = data
                .map(
                    (gestor) => `
                <tr>
                    <td>${gestor.nome}</td>
                    <td>${gestor.cpf}</td>
                    <td>${gestor.gestorAdministrativo ? "Sim" : "N�o"}</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="editarGestor('${gestor.id}')">Editar</button>
                        <button class="btn btn-danger btn-sm" onclick="deletarGestor('${gestor.id}')">Deletar</button>
                    </td>
                </tr>`
                )
                .join("");
        });
}

// Editar gestor
function editarGestor(id) {
    fetch(`${apiUrl}/${id}`)
        .then((res) => res.json())
        .then((gestor) => {
            document.getElementById("id").value = gestor.id;
            document.getElementById("nome").value = gestor.nome;
            document.getElementById("cpf").value = gestor.cpf;
            document.getElementById("senha").value = gestor.senha;
            document.getElementById("gestorAdministrativo").checked =
                gestor.gestorAdministrativo;
        });
}

// Deletar gestor
function deletarGestor(id) {
    if (confirm("Tem certeza que deseja deletar este gestor?")) {
        fetch(`${apiUrl}/${id}`, {
            method: "DELETE",
        }).then(carregarGestores);
    }
}

