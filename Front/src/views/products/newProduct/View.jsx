import { useState, useEffect } from 'react';
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


import { Chip, FormControl, IconButton, InputLabel, MenuItem, Modal} from '@mui/material';
import Select from '@mui/material/Select';
import './styles.css';
import axios from 'axios';
import { useSession } from '../../../hooks/sessionContext/useSession';

export default function NewProduct({openModal, switchModal}) {

  const [loading, setLoading] = useState(false);
  const [response, setResponse] = useState(null);
  const [images, setImages] = useState([]);
  const [category, setCategory] = useState('')
  const [fabricationDate, setFabricationDate] = useState(null);
  const [listUrlImages, setListUrlImages] = useState([]);
  const [objectData, setObjectData] = useState({})
  const { getUserId } = useSession();

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

  const updateImageToCloud = () => {
    let imagesFormData;
      if(images.length > 0){
          images.forEach(async (img, index) => {
            imagesFormData = new FormData();
            imagesFormData.append('file', img);
            imagesFormData.append('upload_preset', 'fcjwt7om');
            const resolve = await axios.post('https://api.cloudinary.com/v1_1/sebaacr/image/upload', imagesFormData)
            .then( res => (res.data.url))
            setTimeout(() => {
              setListUrlImages( prev => [...prev, resolve])
            }, (images.length * 1000));
          });
      }      
  }

  const categoryChange = (event) => {
    setCategory(event.target.value);
  }

  const parseToDate = (date) => {
    let day = date.date() > 10 ? date.date() : '0'+date.date();
    let month = parseInt(date.month())+1 > 10 ? parseInt(date.month())+1 : '0'+(parseInt(date.month())+1);
    let year = date.year();
    return year+'-'+month+'-'+day;
  }
  
  const handleSubmit = async (event) => {
    event.preventDefault();
    setLoading(true);
    const data = new FormData(event.currentTarget);
    setObjectData({
      name : data.get('name'),
      description : data.get('description'),
      price : parseFloat(data.get('price')+'.0'),
      quantity : parseInt(data.get('quantity')),
      date : parseToDate(fabricationDate),
      category,
      idUser : parseInt(getUserId())
    })
    updateImageToCloud();
  };

  useEffect(() => {
    if(images.length > 0 && listUrlImages.length === images.length){
      const data = { ...objectData, listPhoto : listUrlImages}
      
      axios.post('http://127.0.0.1:5000/saveProduct', data)
      .then( res => {
        setResponse({ status : 'success', msg : 'Producto cargado correctamente'})
        setImages([]);
        setListUrlImages([]);
        setTimeout(() => {
          setLoading(false);
          switchModal();
          setResponse(null);
        }, 2000);
      })
      .catch(error => {
        setLoading(false);
      }) 
    }
  }, [listUrlImages])
  
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
        {response !== null && <Alert severity={response.status}>{response.msg}</Alert>}
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
            <Grid item xs={6}>
              <TextField
                required
                fullWidth
                id="price"
                label="Precio"
                name="price"
                autoComplete="precio"
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                required
                fullWidth
                id="quantity"
                label="Cantidad"
                name="quantity"
                autoComplete="cantidad"
              />
            </Grid>
            <Grid item xs={6}>
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                  <DatePicker
                    label="Fecha fabricación"
                    className='fabricationDate'
                    value={fabricationDate}
                    onChange={(newValue) => {
                      setFabricationDate(newValue);
                    }}
                    renderInput={(params) => <TextField {...params} />}
                  />
              </LocalizationProvider>
            </Grid>
            <Grid item xs={6}>
              <FormControl fullWidth>
                  <InputLabel id="category">Categoria</InputLabel>
                  <Select
                    labelId="category"
                    fullWidth
                    id="category"
                    value={category}
                    label="category"
                    onChange={categoryChange}
                  >
                    <MenuItem value={'Videojuego'}>Videojuego</MenuItem>
                    <MenuItem value={'Música'}>Música</MenuItem>
                    <MenuItem value={'Diario'}>Diario</MenuItem>
                    <MenuItem value={'Revistas'}>Revistas</MenuItem>
                    <MenuItem value={'Adornos'}>Adornos</MenuItem>
                  </Select>
              </FormControl>
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