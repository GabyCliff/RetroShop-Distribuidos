import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Snackbar from '@mui/material/Snackbar';

import LockOutlinedIcon from '@mui/icons-material/LockOutlined';

import { useNavigate } from 'react-router-dom';
import { useSession } from '../../../hooks/sessionContext/useSession';

// import {getBackground} from "../../utils/background";


export default function Login() {

  let navigate = useNavigate();
  const { loginUser , error } = useSession(); 

  const handleSubmit = async (event) => {
    event.preventDefault();
    const values = new FormData(event.currentTarget);
    await loginUser(values.get("username"),values.get("password"));
    error !== null && navigate('/') 
  };

  return (
    <Grid container component="main" sx={{ height: '100vh' }}>
      {error !== null &&
        <Snackbar
          open={error != null}
          anchorOrigin={{vertical: "top", horizontal:"center"}}
          autoHideDuration={6000}
          //onClose={() => setError(null)}
        >
          <Alert severity={error.status} sx={{ width: '100%' }}> {error.msg} </Alert> 
         </Snackbar> 
      }
      
      <CssBaseline />
      <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
              backgroundImage: `linear-gradient(#300042, #43005B), url(https://images.pexels.com/photos/50987/money-card-business-credit-card-50987.jpeg)`,
              backgroundSize: 'cover',
              backgroundRepeat: "no-repeat",
              backgroundPosition: "center center",
              backgroundBlendMode: "color"
          }}
      />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <Box
          sx={{
            my: 8,
            mx: 4,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Iniciar sesión
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="Usuario"
              name="username"
              autoComplete="username"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Contraseña"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Iniciar sesión
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/signUp" variant="body2">
                  Crear cuenta
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Grid>
    </Grid>
  );
}