#include <iostream>
#include <fstream>
#include <iomanip>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <sstream>
#include <math.h>
#include <algorithm>
using namespace std;


const string medoids_ID_number = "medoids_ID_number";
const string nearest_index_number = "nearest_index_number";
const string OUTPUT_FILENAME_1 = "Flow.txt";
const string OUTPUT_FILENAME_2 = "KMedoids.txt";
const string OUTPUT_FILENAME_3 = "KMedoidsE.txt";

enum distanceFormulae {
    Manhattan,
    Euclidean
};

class packet{
public:
    string features;
    int arrival_time;
    int packet_length;
};

class cluster{
public:
    int medoidIndex;
    vector<int> nearest_point;
    void addLink(int index)
    {
        nearest_point.push_back(index);
    }
    void removeLink()
    {
        nearest_point.clear();
    }
};

double computeDistance(vector<vector<double>> flow, int ptA, int ptB, int type) {
    if (type == Euclidean) {
        return sqrt(pow(flow[ptA][0] - flow[ptB][0], 2) +
        pow(flow[ptA][1] - flow[ptB][1], 2) * 1.0);
    } else {
        return abs(flow[ptA][0] - flow[ptB][0]) +
        abs(flow[ptA][1] - flow[ptB][1]);
    }

}

int closeMedoid(int index,vector<vector<double>> dist_matrix, vector<int> medID)
{
    int nearest_Modoid;
    double min_dis=9999999.0;
    double dis;
    for(int k=0;k<medID.size();k++)
    {
        dis=dist_matrix[index][medID[k]];
        if (dis<min_dis)
        {
            min_dis=dis;
            nearest_Modoid=medID[k];
        }
    }
    return nearest_Modoid;
}

bool isMedoid(vector<int> medoid_idx, int key)
{
    if (count(medoid_idx.begin(), medoid_idx.end(), key)) {
        return true;
    } else {
        return false;
    }
}

//generate distance matrix
vector<vector<double>> distance_calculator(vector<vector<double>> flow, int len, int type)
{

    vector<vector<double>> dist_every_point_to_point;
    for (int x=0; x<len; x++) {
        vector<double> temp_destant;
        for (int y=0; y<len; y++) {
            temp_destant.push_back(computeDistance(flow, x, y, type));
        }
        dist_every_point_to_point.push_back(temp_destant);
    }
    return dist_every_point_to_point;
}

// k medoids clustering algrithm function
void assign_points(vector<vector<double>>& flow, map<string, vector<int>>& current_medoids, double& total_cost, int medoid_num, int len, double& sse, int type)
{
    vector<int> medID;//store ID for K medoids
    for (int i = 0; i < medoid_num; i++)
    {
        medID.push_back(current_medoids[medoids_ID_number][i]); // medoids index
    }

    // arrange data into cluster
    vector<vector<double>> dist_matrix;
    dist_matrix = distance_calculator(flow, len, type); // minimum distance for each row of data
    //store the nearest medoids for evert point
    vector<int> nearest_Modoid_ID_list;
    for(int i = 0; i < len; i++)
    {
        int nearest_Modoid_ID;
        nearest_Modoid_ID = closeMedoid(i,dist_matrix,medID);
        nearest_Modoid_ID_list.push_back(nearest_Modoid_ID);
    }
    current_medoids[nearest_index_number] = nearest_Modoid_ID_list;

    // calculate the total cost of all clusters
    vector<double> min_dist_for_every_point;
    for (int i = 0; i < len; i++)
    {
        double dist;
        dist = computeDistance(flow, i, nearest_Modoid_ID_list[i], type);
        min_dist_for_every_point.push_back(dist);
    }

    for (int i = 0; i < len; i++)
    {
        total_cost += min_dist_for_every_point[i];
        sse += pow(min_dist_for_every_point[i],2);
    }
    sse = sse / len;

}

//search in the flow
vector<int> find_flow(string key,vector<packet> packets)
{
    vector<int> target_flow_ID;
    for (int i=0; i<packets.size(); i++) {
        if(packets[i].features==key)
        {
            target_flow_ID.push_back(i);
        }
    }
    return target_flow_ID;
}

//delete flow
void delete_flow(vector<int> target_flow_ID, vector<packet>& packets)
{
    vector <packet>::iterator Iter;
    //remove from end to first
    for (int i=target_flow_ID.size()-1; i>=0; i--) {
        Iter = packets.begin()+target_flow_ID[i];
        packets.erase(Iter);
        Iter = packets.begin();
    }
}


void copyMap(map<string, vector<int> > &m1, map<string, vector<int> > &m2, vector<string> props) {
    for (string key : props) {
        m2[key] = m1[key];
    }
}

set<int> copyVectorToSet(vector<int> v) {
    set<int> s;
    for (int i : v) {
        s.insert(i);
    }
    return s;
}

vector<packet> getPackets(const string &filename)
{
    vector<packet> packets;

    ifstream infile;
    string line;
    infile.open(filename, ios::in);
    getline(infile, line);
    while (getline(infile, line))
    {
        string tmp;
        vector<string> packetInfo;
        stringstream ss(line);
        while (ss >> tmp)
        {
            packetInfo.push_back(tmp);
        }
        packet currentPacket;
        currentPacket.features = (packetInfo.begin(), packetInfo.end() - 2, string(""));
        currentPacket.arrival_time = stoi(packetInfo.end()[-2]);
        currentPacket.packet_length = stoi(packetInfo.end()[-1]);
        packets.push_back(currentPacket);
    }
    infile.close();
    return packets;
}



double k_medoids_cluster(map<string, vector<int>>& current_medoids, vector<vector<double>>& flow, int len, int medoid_num, vector<int> med_idx, int type)
{
    double sse = 0.0;
    map<string, vector<int>> record_medoids;
    vector<int> record_medoids_ID;
    vector<string> vector_tags;
    set<int> current_medodios_set;
    set<int> record_medoids_set;
    double total_cost = 0.;

    current_medoids[medoids_ID_number] = med_idx;
    assign_points(flow, current_medoids, total_cost, medoid_num, len, sse, type);

    record_medoids[medoids_ID_number] = record_medoids_ID;
    current_medodios_set = copyVectorToSet(current_medoids[medoids_ID_number]);
    record_medoids_set = copyVectorToSet(record_medoids[medoids_ID_number]);

    map<string, vector<int>>::iterator iter;
    for (iter = begin(current_medoids); iter != end(current_medoids); iter++)
    {
        vector_tags.push_back(iter->first);
    }

    while (current_medodios_set != record_medoids_set)//if medoids has changed
        {
        map<string, vector<int>> best_medoids;
        copyMap(current_medoids, best_medoids, vector_tags);//from current_medoids to best_medoids
        copyMap(current_medoids, record_medoids, vector_tags);
        map<string, vector<int>> temp_medoids;
        copyMap(current_medoids, temp_medoids, vector_tags);
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < medoid_num; j++)
            {
                if (!isMedoid(best_medoids[medoids_ID_number],i))//if i is not current medoids
                    {
                    double temp_total_cost = 0.;
                    double temp_sse =0.;

                    copyMap(best_medoids, temp_medoids, vector_tags);//from current_medoids to temp_medoids
                    temp_medoids[medoids_ID_number][j] = i;//set I as Medoids

                    assign_points(flow, temp_medoids, temp_total_cost, medoid_num, len, temp_sse, type);//calculate temp_cost

                    //cout << "i: " << i <<", j: "<< j << ", total_cost: " << total_cost << ", temp_total_cost :" <<temp_total_cost << ", sse :" << sse << ", temp_sse :"<< temp_sse<<endl;

                    if (total_cost - temp_total_cost >0 )//if swap can get lower cost then swap
                        {
                        total_cost = temp_total_cost;
                        sse =temp_sse;
                        copyMap(temp_medoids, best_medoids, vector_tags);
                        i=0;
                        j=0;
                        }
                    }
            }
        }

        copyMap(best_medoids, current_medoids, vector_tags);//from best_medoids to current_medoids
        current_medodios_set = copyVectorToSet(current_medoids[medoids_ID_number]);
        record_medoids_set = copyVectorToSet(record_medoids[medoids_ID_number]);
        }
    return total_cost;
}

vector<packet> getPacketsFromFile(const string &FILE_TRAFFIC) {
    ifstream infile;
    string data;
    vector<packet> packets;
    infile.open(FILE_TRAFFIC,ios::in);
    getline(infile,data);
    while (getline(infile, data)) {
        string tmp;
        vector<string> factors;//collect data for a line (generate a)
        stringstream ss(data);
        while (ss>>tmp) {
            factors.push_back(tmp);
        }
        packet pac;
        pac.features=factors[0]+factors[1]+factors[2]+factors[3]+factors[4];
        pac.arrival_time= stoi(factors[5]);
        pac.packet_length= stoi(factors[6]);
        packets.push_back(pac);
    }
    infile.close();
    return packets;
}

vector<vector<double>>
preprocessData(vector<packet> &packets) {
    vector<vector<double>> flow;
    vector<int> flow_idx;
    while (packets.size() != 0) {

        flow_idx=find_flow(packets[0].features,packets);
        if (flow_idx.size()<=1) {//delete flow with only one packet
            delete_flow(flow_idx, packets);
        }
        else
        {
            double time=0;
            double length=0;
            vector<double> flow_result;//used for output
            for (int j=flow_idx.size()-1; j>0; j--) {
                length=length+packets[flow_idx[j]].packet_length;
                time=time+packets[flow_idx[j]].arrival_time-packets[flow_idx[j-1]].arrival_time;
            }
            length=length+packets[0].packet_length;//because j > 0 cannot reach to j = 0, so add this one
            time=time/(flow_idx.size()-1);
            length=length/flow_idx.size();
            flow_result.push_back(time);
            flow_result.push_back(length);
            flow.push_back(flow_result);
            delete_flow(flow_idx, packets);
        }
    }
    return flow;
}

pair<int, vector<int>> getMedoidsData(const string &FILE_MEDOIDS) {
    ifstream infile1;
    string data;
    int medoid_num;
    vector<int> med_idx;
    pair<int, vector<int>> medoidsData;

    infile1.open(FILE_MEDOIDS,ios::in);
    getline(infile1,data);
    medoid_num=stoi(data);//number of medoids
    while (getline(infile1, data)) {
        int num;
        stringstream ss(data);
        while (ss>>num) {
            med_idx.push_back(num);
        }
    }
    infile1.close();
    medoidsData.first = medoid_num;
    medoidsData.second = med_idx;
    return medoidsData;
}

void writeKMeansOutput(vector<vector<double>> &flow, pair<int, vector<int>> &medoidsData, int type) {
    map<string, vector<int>> current_medoids;
    double total_cost = k_medoids_cluster(current_medoids, flow, flow.size(), medoidsData.first, medoidsData.second, type);

    ofstream fout;
    fout.open ("Flow.txt", ios::out | ios::trunc);

    for(int k=0;k<flow.size();k++)
    {
        fout<<k<<" ";
        fout<< fixed << setprecision(2)<<flow[k][0];
        fout<<" ";
        fout<< fixed << setprecision(2)<<flow[k][1]<<endl;
    }

    fout.close();

    ofstream fout1;
    string outputFileName = type == Manhattan ? "KMedoidsClusters.txt" : "KMedoidsClustersE.txt";
    fout1.open(outputFileName,ios::out | ios::trunc);

    fout1 << fixed << setprecision(2)<<total_cost << endl;

    vector<cluster> clusters;
    for(int i=0; i< medoidsData.first; i++)
    {
        cluster clust;
        clusters.push_back(clust);
    }

    for (int l=0; l<clusters.size(); l++) {
        clusters[l].removeLink();
        clusters[l].medoidIndex=current_medoids[medoids_ID_number][l];
        for (int k = 0; k < current_medoids[nearest_index_number].size() ; k++)
        {
            if (current_medoids[nearest_index_number][k] == clusters[l].medoidIndex)
            {
                clusters[l].addLink(k);
            }
        }
    }


    for (int i : current_medoids[medoids_ID_number])
    {
        fout1 << i << " ";
    }

    fout1 << endl;
    for (int i=0; i<clusters.size(); i++)
    {
        for (int j=0; j<clusters[i].nearest_point.size(); j++) {
            fout1<<setprecision(2)<<clusters[i].nearest_point[j]<<" ";
        }
        fout1<<endl;
    }
    fout1.close();
}

int main(int argc, const char * argv[]) {
    const string FILE_TRAFFIC=argv[1];
    const string FILE_MEDOIDS=argv[2];

    vector<packet> packets = getPacketsFromFile(FILE_TRAFFIC);

    vector<vector<double>> flow = preprocessData( packets);

    pair<int, vector<int>> medoidsData = getMedoidsData(FILE_MEDOIDS);

    //k_Medoids algorithm
    writeKMeansOutput(flow, medoidsData, Manhattan);
    writeKMeansOutput(flow, medoidsData, Euclidean);

    return 0;
}