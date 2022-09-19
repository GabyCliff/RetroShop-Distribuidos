import { useState } from 'react';
import Container from '@mui/material/Container';
import MyProductCard from './myProductCard/View';
import { Button, Grid } from '@mui/material';
import './styles.css';
import { AddCircle } from '@mui/icons-material';
import NewProduct from '../products/newProduct/View';


const rows = [
  { name: 'Kageyama de Bokita', description: 'Jugador de Voley, colocador', price: 999999.9, quantity : 1, listPhotos : ['https://res.cloudinary.com/sebaacr/image/upload/v1663537574/retroShop/kageyamaBokita_gjhssv.jpg']},
  { name: 'Nishinoya de Bokita', description: 'Jugador de Voley, libero', price: 99999.9, quantity : 1, listPhotos : ['https://res.cloudinary.com/sebaacr/image/upload/v1663537574/retroShop/liberoBokita_v4idzs.jpg']}
];
const MyProducts = () => {
  const [products, setProducts] = useState(rows);
  const [openModal, setOpenModal] = useState(false);

  const switchModal = () => {setOpenModal(prev => !prev)}
  
  return (
      <Container component="main" sx={{pt:4}}>
        <Grid item xs={12}>
            <h1 className='title'>
                Mis Productos
            </h1>
            <Button 
              variant="outlined" 
              startIcon={<AddCircle color="primary"/>}
              type="submit"
              onClick={switchModal}
              >
                Agregar Producto
          </Button>
        </Grid>
        <Grid item xs={12}>
          { products && products.length > 0 &&
              products.map( (product,index) => (
                <MyProductCard product={product} key={Math.random()*index}/>
              ))  
          }
        </Grid>
        <NewProduct openModal={openModal} switchModal={switchModal}/>
      </Container>
  );
}

export default MyProducts;