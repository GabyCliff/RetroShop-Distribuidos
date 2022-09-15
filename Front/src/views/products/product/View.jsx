import * as React from 'react';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import CircularProgress from "@mui/material/CircularProgress";
import { getProduct } from './api.js';


function Product() {

  let [loading, setLoading] = React.useState(false);
  let [response, setResponse] = React.useState(null);
  
  React.useEffect(() => {
    const promise = getProduct(1)
    promise.then((msg) => {
      setResponse(msg)
    })
    .catch((error) => {
      setResponse(error);
    })
    .finally(() => setLoading(false));
}, []);
  
const card = (
  <React.Fragment>
    <CardContent sx={{textAlign:"left", height:"40vh"}}>
      <Typography sx={{ fontSize: 28, align:"right" }} color="text.secondary" gutterBottom>
        Nombre: {response.name}
      </Typography>
      <Typography sx={{ fontSize: 28, align:"right" }} color="text.secondary" gutterBottom>
        Descripción: {response.description}
      </Typography>
      <Typography sx={{ fontSize: 28, align:"right" }} color="text.secondary" gutterBottom>
        Precio: {response.price}
      </Typography>
      <Typography sx={{ fontSize: 28, align:"right" }} color="text.secondary" gutterBottom>
        Cantidad disponible: {response.available}
      </Typography>
      {/* <Typography sx={{ fontSize: 28, align:"right" }} color="text.secondary" gutterBottom>
        Fecha de Fabricación:
      </Typography> */}
    </CardContent>
  </React.Fragment>
);


  return (
    <div>
      <Grid container spacing={2} sx={{ p:4 }}>
        <Grid item xs={6}>
          <Box
            component="img"
            sx={{ borderRadius: '16px' }}
            alt="The house from the offer."
            src="https://images.unsplash.com/photo-1512917774080-9991f1c4c750?auto=format&w=350&dpr=2"
          />
        </Grid>
        <Grid item xs={6}>
          <Box sx={{ minWidth: 900, minHeight: "100%" }}>
            <Card variant="outlined">{card}</Card>
            <Stack alignItems="center">
                {loading? <CircularProgress /> :
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Comprar
                </Button>
                }
              </Stack>
          </Box>
        </Grid>
      </Grid>
    </div>
  );
}

export default Product;