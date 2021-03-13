import React from "react";
import { Grid } from "@material-ui/core";
import { makeStyles } from "@material-ui/styles";
import MUIDataTable from "mui-datatables";

// components
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
  }
];

const columns = [
  {
   name: "name",
   label: "Name",
  },
  {
   name: "company",
   label: "Company"
  },
  {
   name: "city",
   label: "City"
  },
  {
   name: "state",
   label: "State"
  },
 ];
 
 const data = [
  { name: "Joe James", company: "Test Corp", city: "Yonkers", state: "NY" },
  { name: "John Walsh", company: "Test Corp", city: "Hartford", state: "CT" },
  { name: "Bob Herm", company: "Test Corp", city: "Tampa", state: "FL" },
  { name: "James Houston", company: "Test Corp", city: "Dallas", state: "TX" },
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
            data={data}
            columns={columns}
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
