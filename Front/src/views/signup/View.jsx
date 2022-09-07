import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Snackbar from '@mui/material/Snackbar';
import CircularProgress from "@mui/material/CircularProgress";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import {registerAPI} from "./api";

export default function SignUp() {

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
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Registrarse
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="user"
                label="Usuario"
                name="user"
                autoComplete="username"
                helperText="Todos en la plataforma te reconocerán por este nombre"
              />
            </Grid>
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
                id="apellido"
                label="Apellido"
                name="apellido"
                autoComplete="apellido"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="dni"
                label="DNI"
                name="dni"
                autoComplete="dni"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="email"
                label="Email"
                name="email"
                autoComplete="email"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Contraseña"
                type="password"
                id="password"
                autoComplete="new-password"
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
                  Crear cuenta
                </Button>
                }
              </Stack>
            </Grid>
          </Grid>
          <Grid container justifyContent="flex-end">
            <Grid item>
              <Link href="/signin" variant="body2">
                Ya tengo una cuenta
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </Container>
  );
}