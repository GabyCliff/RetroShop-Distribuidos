import React, { useState } from 'react';
import CardProduct from './cardProduct/view';
import './styles.css';

function Products() {
  const [productsData, setproductsData] = useState([])
  return (
    <div className='productsParent'>
      <div className='filtersParent'>
          <h2>Filters</h2>
      </div>
      <div className='productListParent'>
        <h2>Products list</h2>
        {/*productsData && 
          productsData.map( product => 
            <div className='productItem'>
              <CardProductProduct product={product}/>
            </div>
          )*/
        }
        <div className='productItem'>
              <CardProduct/>
            </div>
            <div className='productItem'>
              <CardProduct/>
            </div>
            <div className='productItem'>
              <CardProduct/>
            </div>
            <div className='productItem'>
              <CardProduct/>
            </div>
      </div>
    </div>
  )
}

export default Products;