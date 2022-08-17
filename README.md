
# Perpustakaan

Perpustakaan merupakan rest api yang digunakan 
untuk menyimpan dan mengolah data pada perpustakaan. 




## API Reference
Route list
### URL Bebas
Semua orang dapat menggunakan Route ini dengan bebas
|Metode| URL                  |Type  | Deskripsi                             |  
|:---- |:-------------------- |:---- |:------------------------------------- |
|POST  | `/auth/do-login`     | User | Url Dasar untuk mendapakan token      |
|POST  | `/auth/do-register`  | User | Url Dasar untuk melakukan pendaftaran |


### URL Terbatas
Hanya user dengan role tertentu yang dapat mengakses

|Metode   |URL                    |Tipe                  |Deskripsi                | Anggota                                                  |Petugas         | Admin | 
|:------  |:--------------------- |:-------------------- |:----------------------- |:---------------------------------------------------------| :------------- | :------------ |
| GET     | `/buku/${query}`      | String               | Mencari Buku            | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/buku`               | Buku                 | Menabahkan Buku         | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| DELETE  | `/buku/${id}`         | Integer              | Menghapus Buku          | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/peminjaman`         | Peminjaman           | Menabahkan peminjaman   | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/pengembalian`       | Pengembalian         | Menabahkan pengembalian | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| PUT     | `/peminjaman/${id}`   | Integer/Peminjaman   | Menabahkan peminjaman   | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| PUT     | `/pengembalian/${id}` | Integer/pengembalian | Menabahkan pengembalian | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/anggota`            | Anggota              | Menabahkan anggota      | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/user`               | User                 | Menabahkan user         | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/user/with-anggota`  | UserWithAnggota      | Menabahkan user anggota | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |
| POST    | `/user/with-pegawai`  | UserWithPegawai      | Menabahkan user pegawai | ![#ED1221](https://via.placeholder.com/10/ED1221.png)    | ![#ED1221](https://via.placeholder.com/10/ED1221.png) | ![#21ED12](https://via.placeholder.com/10/21ED12.png) |

### Deskripsi
Penjelasan object setiap request

#### User 

```json
{
    "username" : "username",
    "password" : "password",
    "email" : "email"
}
```

#### Buku

```json
{
    "judul" : "judul",
    "tahunTerbit" : "2022",
    "jumlah" : 9,
    "isbn" : "123456789",
    "pengarang" : {
        "id" : 1
    },
    "penerbit":{
        "id" : 1
    }
}
```

#### Peminjaman

```json
{
    "tglPinjam" : "2021-12-17T16:04:03.930224479Z",
    "tglKembali" : "2021-12-17T16:04:03.930224479Z",
    "anggota" : {
        "id" : 3
    },
    "petugas":{
        "id" : 3
    },
    "buku" : [
        {
            "id" : 19
        }
    ]
}
```

#### Pengembalian

```json
{
    "tglPengembalian" : "21-22-22",
    "denda" : 3000.00,
    "peminjaman" : {
        "id" : 4
    },
    "anggota" : {
        "id" : 3
    },
    "petugas" :{
        "id" : 3
    },
    "buku" : [
        {
            "id" : 19
        }
    ]
}
```
#### Anggota

```json
{
    "nama" : "nama",
    "jenisKelamin" : "cwk",
    "alamat" : "alamat",
    "noTelp" : "noTelp",
    "user" : {
        "id": 9
    }
}
```
