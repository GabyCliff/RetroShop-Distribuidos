import { useState } from 'react';
import Alert from '@mui/material/Alert';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import CloseIcon from '@mui/icons-material/Close';
import CircularProgress from "@mui/material/CircularProgress";
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';


import { fetchWithoutToken } from '../../../helpers/fetch';
import { Chip, IconButton, Modal } from '@mui/material';
import './styles.css';
import axios from 'axios';

export default function NewProduct({openModal, switchModal}) {

  const [loading, setLoading] = useState(false);
  const [response, setResponse] = useState(null);
  const [images, setImages] = useState(null);
  const [fabricationDate, setFabricationDate] = useState(null);

  const saveImages = e => {
    let imagesFiles = Object.entries(e.target.files);
    let imagesFilesArray = [];
    imagesFiles.forEach(img => {
        imagesFilesArray.push(img[1]); 
    });
    imagesFiles.length > 5 ?
      setImages([{error : 'El máximo de imagenes permitido es 5'}])
      :
      setImages(imagesFilesArray);
    
  }

  const handleDeleteImage = (imgToDelete) => () => {
    setImages((images) => images.filter((img) => img.name !== imgToDelete.name));
  };

  const updateImageToCloud = async () => {
    let imagesFormData;
    let listPhotos = [];

    images.length > 0 &&
      images.forEach( async (img) => {
        imagesFormData = new FormData();
        imagesFormData.append('file', img);
        imagesFormData.append('upload_preset', 'fcjwt7om');
        await axios.post('https://api.cloudinary.com/v1_1/sebaacr/image/upload', imagesFormData)
        .then(res => {
          listPhotos.push(res.data.url);
        });
      });

    return listPhotos;
  }

  const handleSubmit = async (event) => {
    event.preventDefault();
    setLoading(true);
    const data = new FormData(event.currentTarget);
    let listPhotos = await updateImageToCloud();
    const objectData = {
      name : data.get('name'),
      description : data.get('description'),
      listPhotos,
      price : data.get('price'),
      available : data.get('quantity'),
      //fabricationDate : data.get('fabricationDate'),
    }
    fetchWithoutToken('saveProduct', objectData, 'POST')
    .then( res => {
      console.log(res);
      setResponse({ status : '', msg : 'Producto cargado correctamente'})
      setImages([]);
      setLoading(false);
      switchModal();
    })
    .catch(error => {
      console.log('hubo un error ', error);
    });
    
  };

  const modalStyle = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid white',
    borderRadius: '.5rem',
    boxShadow: 24,
    p: 4,
  };

  return (
    <Modal
      open={openModal}
      onClose={switchModal}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
        <Box component="form" noValidate onSubmit={handleSubmit} sx={modalStyle}>
          <Grid container  direction="row" justifyContent="end" spacing={2}>
            <Grid item xs={2}>
              <IconButton aria-label="cerrar" onClick={switchModal}>
                <CloseIcon />
              </IconButton>
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="name"
                label="Nombre"
                name="name"
                autoComplete="nombre"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="description"
                label="Descripción"
                name="description"
                autoComplete="descripcion"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="price"
                label="Precio"
                name="price"
                autoComplete="precio"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="quantity"
                label="Cantidad"
                name="quantity"
                autoComplete="cantidad"
              />
            </Grid>
            <Grid item xs={12}>
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                  <DatePicker
                    label="Fecha de fabricación"
                    className='fabricationDate'
                    value={fabricationDate}
                    onChange={(newValue) => {
                      setFabricationDate(newValue);
                    }}
                    renderInput={(params) => <TextField {...params} />}
                  />
              </LocalizationProvider>
            </Grid>
            <Grid item xs={12}>
              <Stack direction="row" alignItems="center" spacing={2}>
                <Button variant="contained" component="label">
                  Subir imagen
                  <input 
                    hidden 
                    onChange={saveImages} 
                    accept="image/png, image/jpeg" 
                    multiple 
                    type="file" 
                    max={5}
                  />
                </Button>
              </Stack>
            </Grid>
            {images != null && images.length !== 0 &&
              <Grid item xs={12}>
                <ul className='listPhotos'>
                  {images.map((img,index) => (
                    <>
                    {!img.error ?
                        <li className='listItem' key={index}>
                            <Chip
                              label={img.name}
                              onDelete={handleDeleteImage(img)}
                            />
                        </li>
                        :
                        <li style={{width : '100%'}}><Alert severity="error" key={index}>{img.error}</Alert></li>
                      }
                    </>))
                  }
                </ul>
              </Grid>
            }
            <Grid item xs={12}>
              <Stack alignItems="center">
                {loading? <CircularProgress /> :
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Cargar producto
                </Button>
                }
              </Stack>
            </Grid>
          </Grid>
          </Box>
      </Modal>
  );
}