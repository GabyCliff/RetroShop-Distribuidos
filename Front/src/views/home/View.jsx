import * as React from 'react';
import Navbar from '../../components/navBar';
import { Outlet } from 'react-router-dom';

function Home() {
	
	return(
		<div>
            <Navbar/>
			<Outlet/>
        </div>
	)

}

export default Home;