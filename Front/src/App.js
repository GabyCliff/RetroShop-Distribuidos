import './App.css';
import { Routes, Route, Link } from "react-router-dom";
import Home from './views/home/View.jsx';
import SignUp from './views/signup/View.jsx';
import Login from './views/login/View.jsx';
import NewProduct from './views/newProduct/View.jsx';
import AddWalletCredit from './views/addWalletCredit/View.jsx';
import Product from './views/product/View.jsx';
import MisPublicaciones from './views/misPublicaciones/View.jsx'; 

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signUp" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
        <Route path="/newProduct" element={<NewProduct />} />
        <Route path="/addWalletCredit" element={<AddWalletCredit />} />
        <Route path="/product" element={<Product />} />
        <Route path="/mispublicaciones" element={<MisPublicaciones />} />
      </Routes>
    </div>
  );
}

export default App;
