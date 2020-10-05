// INSERT JS HERE
function calculaPrecio(checkIn, checkOut, precioHab) {
    var fecha1 = moment(checkIn);
    var fecha2 = moment(checkOut);

    var precio = fecha2.diff(fecha1, 'days') * precioHab;
    return precio;
}

