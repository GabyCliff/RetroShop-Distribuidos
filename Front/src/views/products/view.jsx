import React, { useState } from 'react';
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
        {productsData && 
          productsData.map( product => 
            <div className='productItem'>
              <cardProduct product={product}/>
            </div>
          )
        }
      </div>
    </div>
  )
}

export default Products;