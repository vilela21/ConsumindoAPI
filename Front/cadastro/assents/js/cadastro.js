'use strict';

const limparFormulario = () => {
  document.getElementById('endereco').value = '';
  document.getElementById('bairro').value = '';
  document.getElementById('cidade').value = '';
  document.getElementById('estado').value = '';
};

const preencherFormulario = (endereco) => {
  document.getElementById('endereco').value = endereco.logradouro || '';
  document.getElementById('bairro').value = endereco.bairro || '';
  document.getElementById('cidade').value = endereco.localidade || '';
  document.getElementById('estado').value = endereco.uf || '';
};

const eNumero = (numero) => /^[0-9]+$/.test(numero);

const cepValido = (cep) => cep.length === 8 && eNumero(cep);

const pesquisarCep = async () => {
  limparFormulario();
  const cep = document.getElementById('cep').value.replace(/\D/g, '');
  const erroCep = document.getElementById('cepErro');
  erroCep.textContent = '';

  if (cepValido(cep)) {
    try {
      const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
      const endereco = await response.json();
      if (endereco.erro) {
        erroCep.textContent = 'CEP não encontrado.';
      } else {
        preencherFormulario(endereco);
      }
    } catch (error) {
      erroCep.textContent = 'Erro ao buscar o CEP.';
    }
  } else {
    erroCep.textContent = 'CEP inválido.';
  }
};

document.getElementById('cep').addEventListener('focusout', pesquisarCep);

// Envio para API Spring Boot
document.getElementById('imageForm').addEventListener('submit', async function (event) {
  event.preventDefault();

  const usuario = {
    nome: document.getElementById('nome').value,
    email: document.getElementById('email').value,
    senha: document.getElementById('senha').value,
    cep: document.getElementById('cep').value,
    endereco: document.getElementById('endereco').value,
    numero: document.getElementById('numero').value,
    bairro: document.getElementById('bairro').value,
    cidade: document.getElementById('cidade').value,
    estado: document.getElementById('estado').value
  };

  try {
    const response = await fetch('http://localhost:8080/api/usuarios', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(usuario)
    });

    if (response.ok) {
      alert('Usuário cadastrado com sucesso!');
      document.getElementById('imageForm').reset();
    } else {
      alert('Erro ao cadastrar usuário. Verifique os dados.');
    }
  } catch (error) {
    alert('Erro na conexão com a API!');
    console.error(error);
  }
});
