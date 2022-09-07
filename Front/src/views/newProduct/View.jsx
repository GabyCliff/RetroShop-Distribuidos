import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Snackbar from '@mui/material/Snackbar';
import CircularProgress from "@mui/material/CircularProgress";
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import NavBar from '../../components/navBar.jsx';

import {registerAPI} from "./api";

export default function NewProduct() {

  let [loading, setLoading] = React.useState(false);
  let [response, setResponse] = React.useState(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    setLoading(true);
    registerAPI(data.get("email"), data.get("password"), data.get("user"), data.get("facebook"), data.get("instagram"), data.get("whatsapp"))
      .then((msg) => {
        setResponse(msg);
      })
      .catch((error) => {
        setResponse(error);
      })
      .finally(() => setLoading(false));
  };

  return (
    <div>
    <NavBar/>
    <Container component="main" maxWidth="xs">
      {response != null ?
        <Snackbar
          open={response != null}
          anchorOrigin={{vertical: "top", horizontal:"center"}}
          autoHideDuration={6000}
          onClose={() => setResponse(null)}
        >
          <Alert severity={response.status} sx={{ width: '100%' }}> {response.msg} </Alert> 
         </Snackbar> 
        : <></> }
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
          <AddCircleOutlineIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Publicar nuevo producto
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="nombre"
                label="Nombre"
                name="nombre"
                autoComplete="nombre"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="descripcion"
                label="Descripción"
                name="descripcion"
                autoComplete="descripcion"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="precio"
                label="Precio"
                name="precio"
                autoComplete="precio"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="cantidad"
                label="Cantidad"
                name="cantidad"
                autoComplete="cantidad"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="fechaFabricacion"
                label="Fecha de Fabricación"
                type="fechaFabricacion"
                id="fechaFabricacion"
              />
            </Grid>
            <Grid item xs={12}>
              <Button
                variant="contained"
                component="label"
              >
                Upload File
                <input
                  type="file"
                  hidden
                />
              </Button>
            </Grid>
            <Grid item xs={12}>
              <Stack alignItems="center">
                {loading? <CircularProgress /> :
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Crear cuenta
                </Button>
                }
              </Stack>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </Container>
    </div>
  );
}