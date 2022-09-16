const baseUrl = 'http://127.0.0.1:5000';

/**
 * Funciones que se encargan de hacer las peticiones HTTP correspondientes segun el metodo recibido
 * en la constante method, que si no recibe ninguno por defecto es un GET a una API en cuestion
 * segun el endpoint recibido por parametro donde se envian los datos a traves del body mediante
 * la constante data
 */

const fetchWithoutToken = async (endpoint, data, method = 'GET') => {
	const url = `${baseUrl}/${endpoint}`;

	if (method === 'GET') {
		return await fetch(url);
	} 
    else {
		return await fetch(url, {
			method,
			headers: {
				'Content-type': 'application/json',
			},
			body: JSON.stringify(data),
		})
			.then((response) => response.json()) 
			.catch((error) => {
				throw new Error(`Ocurrió un error (${error.message})`);
			});
	}
};

export { fetchWithoutToken };