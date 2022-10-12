import React from 'react';
import { Image } from 'cloudinary-react';
import './styles.css';
import { useSession } from '../../../hooks/sessionContext/useSession';
import axios from 'axios';

const MyProductCard = ({product}) => {
    const {name, description, listPhotos, price, quantity, id} = product;
    const { getUserName } = useSession();

    const parseToDate = (date) => {
        let day = date.getDate() > 9 ? date.getDate() : '0'+date.getDate();
        let month = parseInt(date.getMonth())+1 > 9 ? parseInt(date.getMonth())+1 : '0'+(parseInt(date.getMonth())+1);
        let year = date.getFullYear();
        return year+'-'+month+'-'+day;
      }

    const handleSubmitUpdate = () => {
        const date = new Date();
        axios.post('http://127.0.0.1:5000/add_message_update_product', {
            username : getUserName(),
            id_product : id,
            old_name :   name,
            old_price: price,
            new_name : "Jabon plusbell",
            new_price : 700,
            edition_date : parseToDate(date)
        }).then( res => {
        console.log(res)
        })
    }
    
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
                <button type="submit" className='productButton' onClick={handleSubmitUpdate} >
                    Modificar
                </button>
                <button type="submit" className='productButton lightBlue'>
                    Ver producto
                </button>
                <button type="submit" className='productButton lightBlue'>
                    Ver producto
                </button>
            </div>
        </div>
    )
}

export default MyProductCard;