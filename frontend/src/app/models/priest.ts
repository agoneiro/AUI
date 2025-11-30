export interface Priest {
    id: string;
    name: string;
    age: number;
    parish?: {
        id: string;
        name: string;
    };
}