import { parse } from "csv-parse/sync";
import fs from "fs";
import path from "path";

type Record = {
    // The number of columns in the CSV file
    // should match number number of names set her
    tasks: string;
};

export default function readCSV(filePath: string): Record[] {
    // Read the CSV file and parse it into an array of records
    const records: Record[] = parse(
        fs.readFileSync(path.join(__dirname, filePath), "utf-8"),
        {
            columns: true,
            skipEmptyLines: true,
        }
    );

    // Return the array of records
    return records;
}