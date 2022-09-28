import { useEffect, useState } from 'react';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Snackbar from '@mui/material/Snackbar';
import CircularProgress from "@mui/material/CircularProgress";

import { fetchWithoutToken } from '../../../helpers/fetch';
import { useSession } from '../../../hooks/sessionContext/useSession';

export default function AddWalletCredit() {

  let [loading, setLoading] = useState(false);
  let [response, setResponse] = useState(null);
  let [saldo, setSaldo] = useState(0);
  const { getWalletValues , getUserId} = useSession();

  useEffect(() => {
    const {wallet , walletId } = getWalletValues();
      wallet &&
        fetchWithoutToken('vw/findOneById',{idVW : parseInt(walletId)},'POST')
          .then(({virtualWalletResponse}) => {
            virtualWalletResponse.balance && setSaldo(virtualWalletResponse.balance)
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
    fetchWithoutToken('vw/update',{
      idUser: parseInt(getUserId()),
      is_money_income: true,
      value : parseInt(data.get('balance'))
    },'POST')
    .then(({virtualWalletResponse}) => {
      setSaldo(virtualWalletResponse.balance);
    })
    .catch((error) => {
      setResponse(error);
    })
    .finally(() => setLoading(false));
  }; 

  return (
    <div>
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
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Typography component="h1" variant="h5">
          Saldo actual: ${saldo}
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="balance"
                label="¿Cuanto desea cargar?"
                type="balance"
                id="balance"
              />
            </Grid>
            <Grid item xs={12}>
              <Stack alignItems="center">
                {loading ? <CircularProgress /> :
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