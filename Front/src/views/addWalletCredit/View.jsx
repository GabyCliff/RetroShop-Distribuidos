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
import {getSession} from '../../utils/session'

import {registerAPI, getAPI} from "./api";

export default function AddWalletCredit() {

  let [loading, setLoading] = React.useState(false);
  let [response, setResponse] = React.useState(null);
  let [saldo, setSaldo] = React.useState(0);

  React.useEffect(() => {
    const promise = getAPI((JSON.parse(getSession().data).dni).toString())
      promise.then((msg) => {
        console.log(msg)
        setSaldo(msg.balance);
        setResponse(msg);
      })
      .catch((error) => {
        setResponse(error);
      })
      .finally(() => setLoading(false));
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    setLoading(true);
    const promise = registerAPI(data.get("numTarjeta"), data.get("saldoACargar"), true)
      promise.then((msg) => {
        setSaldo(msg.balance);
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
          Cargar crédito en la billetera
        </Typography>
        <Typography component="h1" variant="h5">
          Su saldo es: ${saldo}
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="numTarjeta"
                label="Número de Tarjeta"
                name="numTarjeta"
                autoComplete="numTarjeta"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="saldoACargar"
                label="Saldo A Cargar"
                type="saldoACargar"
                id="saldoACargar"
              />
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
                  Agregar credito
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