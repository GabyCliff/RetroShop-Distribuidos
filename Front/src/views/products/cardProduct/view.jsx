import React from "react";
//importo las imagenes
import img from "../img/img01.jpg";
const CardProduct = () => {
    return (
        <>
                <div className="producto">
                    <a href="#">
                    <div className="producto_img">
                        <img src={img} alt="" />
                    </div>
                    </a>
                    <div className="producto_footer">
                        <h1>Title</h1>
                        <p>Categoria</p>
                        <p className="price">$320</p>   
                    </div>
                    <div className="buttom">
                        <button className="btn">
                            Agregar al carro
                        </button>
                        <div>
                            <a href="#" className="btn">Vista</a>
                        </div>
                    </div>
                </div>
        </>
        ) 
}
export default CardProduct;