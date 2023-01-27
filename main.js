const encrypt = text => {
    return text
    .replace(/e/g, "enter")
    .replace(/i/g, "imes")
    .replace(/a/g, "ai")
    .replace(/o/g, "ober")
    .replace(/u/g, "ufat")
}

const decrypt = text => {
    return text
    .replace(/enter/g, "e")
    .replace(/imes/g, "i")
    .replace(/ai/g, "a")
    .replace(/ober/g, "o")
    .replace(/ufat/g, "u")
}

const pattern = /[A-ZÁÉÍÓÚÜÑáéíóúüñ]/;

function encriptar(e) {
    e.preventDefault();


    let text = document.getElementById('texto').value;

    if (pattern.test(text) == true) {
        alterta();
        sinResultado();
        return;
    }

    if (text != '') {
        text = encrypt(text);
        resultado(text);
    } else {
        sinResultado();
    }
}

function desencriptar(e) {
    e.preventDefault();


    let text = document.getElementById('texto').value;

    if (pattern.test(text) == true) {
        alterta();
        sinResultado();
        return;
    }

    if (text != '') {
        text = decrypt(text);
        resultado(text);
    } else {
        sinResultado();
    }
}


async function copiarPortapapeles() {
    let text = document.getElementById('resultadoo').innerHTML;
    try {
        await navigator.clipboard.writeText(text);

        console.log("Texto copiado al portapapeles");
    } catch (err) {

        console.error("Error al copiar texto al portapapeles:", err);
    }
}

function resultado(text) {
    document.getElementById('resultadoo').innerHTML = text;
    document.getElementById('vacio').classList.add('disable');
    document.getElementById('resultado').classList.remove('disable');
}

function sinResultado() {
    document.getElementById('vacio').classList.remove('disable');
    document.getElementById('resultado').classList.add('disable');
}

function alterta() {
    document.getElementById('alertText').classList.remove('disable');
    setTimeout(function() {
        document.getElementById('alertText').classList.add('disable');}, 2000);
}