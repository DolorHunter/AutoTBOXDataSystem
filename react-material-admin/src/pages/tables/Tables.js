import React from "react";
import { Grid } from "@material-ui/core";
import { makeStyles } from "@material-ui/styles";
import MUIDataTable from "mui-datatables";

// components
import PageTitle from "../../components/PageTitle";
import Widget from "../../components/Widget";
import Table from "../dashboard/components/Table/Table";

const tableData = [
  {
    id: 0,
    name: "Mark Otto",
    email: "ottoto@wxample.com",
    product: "ON the Road",
    price: "$25 224.2",
    date: "11 May 2017",
    city: "Otsego",
    status: "Sent"
  },
  {
    id: 1,
    name: "Jacob Thornton",
    email: "thornton@wxample.com",
    product: "HP Core i7",
    price: "$1 254.2",
    date: "4 Jun 2017",
    city: "Fivepointville",
    status: "Sent"
  },
  {
    id: 2,
    name: "Larry the Bird",
    email: "bird@wxample.com",
    product: "Air Pro",
    price: "$1 570.0",
    date: "27 Aug 2017",
    city: "Leadville North",
    status: "Pending"
  },
  {
    id: 3,
    name: "Joseph May",
    email: "josephmay@wxample.com",
    product: "Version Control",
    price: "$5 224.5",
    date: "19 Feb 2018",
    city: "Seaforth",
    status: "Declined"
  },
  {
    id: 4,
    name: "Peter Horadnia",
    email: "horadnia@wxample.com",
    product: "Let's Dance",
    price: "$43 594.7",
    date: "1 Mar 2018",
    city: "Hanoverton",
    status: "Sent"
  }
];

const datatableData = [
  ["Joe James", "Example Inc.", "Yonkers", "NY"],
  ["John Walsh", "Example Inc.", "Hartford", "CT"],
  ["Bob Herm", "Example Inc.", "Tampa", "FL"],
  ["James Houston", "Example Inc.", "Dallas", "TX"],
  ["Prabhakar Linwood", "Example Inc.", "Hartford", "CT"],
  ["Kaui Ignace", "Example Inc.", "Yonkers", "NY"],
  ["Esperanza Susanne", "Example Inc.", "Hartford", "CT"],
  ["Christian Birgitte", "Example Inc.", "Tampa", "FL"],
  ["Meral Elias", "Example Inc.", "Hartford", "CT"],
  ["Deep Pau", "Example Inc.", "Yonkers", "NY"],
  ["Sebastiana Hani", "Example Inc.", "Dallas", "TX"],
  ["Marciano Oihana", "Example Inc.", "Yonkers", "NY"],
  ["Brigid Ankur", "Example Inc.", "Dallas", "TX"],
  ["Anna Siranush", "Example Inc.", "Yonkers", "NY"],
  ["Avram Sylva", "Example Inc.", "Hartford", "CT"],
  ["Serafima Babatunde", "Example Inc.", "Tampa", "FL"],
  ["Gaston Festus", "Example Inc.", "Tampa", "FL"],
];

const useStyles = makeStyles(theme => ({
  tableOverflow: {
    overflow: 'auto'
  }
}))

export default function Tables() {
  const classes = useStyles();
  return (
    <>
      <Grid container spacing={4}>
        <Grid item xs={12}>
          <MUIDataTable
            title="Employee List"
            data={datatableData}
            columns={["Name", "Company", "City", "State"]}
            options={{
              filterType: "checkbox",
            }}
          />
        </Grid>
        <Grid item xs={12}>
          <Widget title="Material-UI Table" upperTitle noBodyPadding bodyClass={classes.tableOverflow}>
            <Table data={tableData} />
          </Widget>
        </Grid>
      </Grid>
    </>
  );
}
