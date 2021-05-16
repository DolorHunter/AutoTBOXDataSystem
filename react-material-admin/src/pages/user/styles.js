import { makeStyles } from "@material-ui/styles";

export default makeStyles(theme => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    width: "100vw",
    marginBottom: theme.spacing(5),
  },
  left: {
    marginLeft: theme.spacing(5),
    marginRight: theme.spacing(5),
    float: 'left',
    width: '55%',
  },
  right: {
    marginLeft: theme.spacing(5),
    marginRight: theme.spacing(5),
    width: '30%',
    overflow: 'hidden',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: '25ch',
  },
  button: {
    marginTop: theme.spacing(3),
    marginLeft: theme.spacing(3),
    marginRight: theme.spacing(3),
  },
  buttonLoader: {
    marginLeft: theme.spacing(1),
  },
  large: {
    width: theme.spacing(20),
    height: theme.spacing(20),
  },
}))