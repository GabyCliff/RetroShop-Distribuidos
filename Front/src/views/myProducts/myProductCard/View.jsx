import React from 'react';
import { Image } from 'cloudinary-react';
import './styles.css';

const MyProductCard = ({product}) => {
    const {name, description, listPhotos, price, quantity} = product;
    return (
        <div className='productContainer'>
            <Image 
                className='productImage'
                cloudName='sebaacr'
                publicId={listPhotos[0]}
            />
            <div className='productDescription'>
                <h2>{name}</h2>
                <h3>{description}</h3>
            </div>
            <div className='productPriceQuantity'>
                <h4>$ {price}</h4>
                <p>En stock: {quantity}</p>
            </div>
            <div className='actionButtons'>
                <button type="submit" className='productButton'>
                    Modificar
                </button>
                <button type="submit" className='productButton lightBlue'>
                    Ver producto
                </button>
            </div>
        </div>
    )
}

export default MyProductCard;