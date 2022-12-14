import './App.css';
import { Routes, Route, Link } from "react-router-dom";
import Home from './views/home/View.jsx';
import SignUp from './views/signup/View.jsx';
import Login from './views/login/View.jsx';
import NewProduct from './views/newProduct/View.jsx';
import AddWalletCredit from './views/addWalletCredit/View.jsx';
import AddWallet from './views/addWallet/View.jsx';
import Product from './views/product/View.jsx';
import MisPublicaciones from './views/misPublicaciones/View.jsx'; 

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/crearusuario" element={<SignUp />} />
        <Route path="/newProduct" element={<NewProduct />} />
        <Route path="/addWallet" element={<AddWallet />} />
        <Route path="/addWalletCredit" element={<AddWalletCredit />} />
        <Route path="/product" element={<Product />} />
        <Route path="/mispublicaciones" element={<MisPublicaciones />} />
      </Routes>
    </div>
  );
}

export default App;
