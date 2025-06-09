'use strict';

const limparFormulario = () => { 
    document.getElementById('endereco').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('cidade').value = '';
    document.getElementById('numero').value = ''; // Campo faltante!
}

const preencherFormulario = (endereco) => {
    document.getElementById('endereco').value = endereco.logradouro || '';
    document.getElementById('bairro').value = endereco.bairro || '';
    document.getElementById('cidade').value = endereco.localidade || '';
}

const eNumero = (numero) => /^[0-9]+$/.test(numero);

const cepValido = (cep) => cep.length === 8 && eNumero(cep); 

const pesquisarCep = async() => {
    limparFormulario();
    
    const cep = document.getElementById('cep').value.replace(/\D/g, ''); // Remove não-dígitos
    const url = `https://viacep.com.br/ws/${cep}/json/`;
    
    if (cepValido(cep)){
        try {
            const dados = await fetch(url);
            const endereco = await dados.json();
            
            if (endereco.erro) {
                document.getElementById('endereco').value = 'CEP não encontrado!';
            } else {
                preencherFormulario(endereco);
            }
        } catch (error) {
            document.getElementById('endereco').value = 'Erro na consulta';
        }
    } else {
        document.getElementById('endereco').value = 'CEP incorreto!';
    }
}

document.getElementById('cep').addEventListener('focusout', pesquisarCep);