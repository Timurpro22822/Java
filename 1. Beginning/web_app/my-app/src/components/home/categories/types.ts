export interface ICategoryCreate {
    files: Array<File>;
    name: string,
    description: string,
}

export interface ICategoryItem {
    id: number;
    name: string;
    description: string,
    file: string;
}