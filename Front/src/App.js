import './App.css';
import { Routes, Route, Link } from "react-router-dom";
import SessionProvider from './hooks/sessionContext/sessionContext';
import Home from './views/home/View.jsx';
import AddWalletCredit from './views/wallet/addWalletCredit/View.jsx';
import AddWallet from './views/wallet/addWallet/View.jsx';
import NewProduct from './views/products/newProduct/View';
import Product from './views/products/product/View.jsx';
import Products from './views/products/view';
import Login from './views/user/login/View.jsx';
import MyProducts from './views/myProducts/View.jsx';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={
              <SessionProvider>
                <Home />
              </SessionProvider>
          }
        >
            <Route
              path=""
              element={<Products />}
            />
            <Route path="login" element={<Login />} />
            <Route path="newProduct" element={<NewProduct />} />
            <Route path="addWallet" element={<AddWallet />} />
            <Route path="addWalletCredit" element={<AddWalletCredit />} />
            <Route path="product" element={<Product />} />
            <Route path="myProducts" element={<MyProducts />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
