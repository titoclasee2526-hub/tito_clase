import React from 'react';
import Practica10 from './Practica10';

const Practica14 = () => {
    let arr: Array<number> = [2, 3, 4, 5, 6, 7, 8, 9, 10]; 
    
    return (
        <div className="grid">
            {
                arr.map((elemento, index) => { 
                    return <Practica10 key={index} tabla={elemento} />; 
                })
            }
        </div>
    );
}

export default Practica14;