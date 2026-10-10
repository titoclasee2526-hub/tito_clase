import React from "react";
import PropTypes from 'prop-types'
function ComponenteApp  () {
    const primos = ["Daniel", "Gonzalez", "Alonso","DAM" ]
    const nombre = "tito";
    return (
        <>
            <h1>Mis datos</h1>
            <h4>{JSON.stringify(primos)}</h4>
            <h1>{nombre}</h1>
        </>
    )
}


export default ComponenteApp;

